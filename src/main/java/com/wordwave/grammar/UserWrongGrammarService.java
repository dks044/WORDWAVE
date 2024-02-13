package com.wordwave.grammar;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.WrongGrammarsDto;
import com.wordwave.grammar.dto.WrongGrammarsResponseDto;
import com.wordwave.grammarbook.GrammarBookService;
import com.wordwave.grammarbook.dto.GrammarIdsOfGrammarBookDto;
import com.wordwave.user.SiteUser;
import com.wordwave.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserWrongGrammarService {
    private final UserWrongGrammarRepository userWrongGrammarRepository;
    private final GrammarRepository grammarRepository;
    private final GrammarBookService grammarBookService;
    private final GrammarService grammarService;
    private final UserService userService;

    /**
     * userName으로 UserWrongGrammar레코드들을 조회한 뒤,
     * 저장된 Grammar의 id들로 Grammar레코드를 가져옵니다.
     * 이들과 lastTryTime과 함께 반환합니다.
     * */
    @Transactional(readOnly = true)
    public WrongGrammarsResponseDto getUserWrongGrammars(String userName) {
        Long userId = getUserIdByUserName(userName);
        List<UserWrongGrammar> userWrongGrammars = this.userWrongGrammarRepository.findByUserId(userId);
        if (userWrongGrammars.isEmpty()) {
            return WrongGrammarsResponseDto.builder().build();
        }

        Set<Long> wrongGrammarIds = collectWrongGrammarIds(userWrongGrammars);
        List<Grammar> wrongGrammars = this.grammarRepository.findGrammarWithGrammarBookAndExampleByIdIn(wrongGrammarIds);

        List<GrammarDto> wrongGrammarDtos = new ArrayList<>();
        for (Grammar wrongGrammar : wrongGrammars) {
            wrongGrammarDtos.add(GrammarDto.builder()
                    .id(wrongGrammar.getId())
                    .sentence(wrongGrammar.getSentence())
                    .grammarExamples(GrammarExampleToGrammarExampleDtoConverter.convert(wrongGrammar.getExamples()))
                    .grammarBookName(wrongGrammar.getGrammarBook().getName())
                    .build());
        }


        return WrongGrammarsResponseDto.builder()
                .wrongGrammars(wrongGrammarDtos)
                .lastTryTime(userWrongGrammars.get(userWrongGrammars.size()-1).getLastTryTime())
                .build();
    }

    /**
     * userName과 grammarBookName을 받아 UserWrongGrammar에서 해당 grammarBook에 속한 grammar들의 id만 조회합니다.
     */
    @Transactional(readOnly = true)
    public GrammarIdsOfGrammarBookDto getUserWrongGrammarBook(String userName, String grammarBookName) {
        Long userId = getUserIdByUserName(userName);
        Long grammarBookId = this.grammarBookService.getGrammarBookIdByGrammarBookName(grammarBookName);
        List<UserWrongGrammar> userWrongGrammars = this.userWrongGrammarRepository.findByUserIdAndGrammarBookId(userId, grammarBookId);
        if (userWrongGrammars.isEmpty()) {
            return GrammarIdsOfGrammarBookDto.builder().build();
        }
        Set<Long> wrongGrammarIds = collectWrongGrammarIds(userWrongGrammars);

        return GrammarIdsOfGrammarBookDto.builder()
                .id(grammarBookId)
                .name(grammarBookName)
                .grammarIds(new ArrayList<>(wrongGrammarIds))
                .build();
    }

    /**
     * userName, grammarBookName, wrongGrammarIds, lastTryTime을 받아 저장합니다.
     * <p>1. userName으로 User의 id를 가져옵니다.</p>
     * <p>2. wrongGrammarsDto의 grammarBookName과 userId로, 특정 user의 특정 grammarBook에 해당하는 userWrongGrammar를 조회합니다.</p>
     * <p>3-1. 조회한 userWrongGrammar가 비어있다면 모든 wrongGrammarIds를 저장합니다.</p>
     * <p>3-2. 비어있지 않다면 userWrongGrammar들 중 wrongGrammarIds에 없는 것들은 삭제합니다.</p>
     * <p>3-3. wrongGrammarIds에만 있는 것들은 새로운 userWrongGrammar로 저장합니다.</p>
     * <p>3-4. 양쪽 모두에 있는 것들은 lastTryTime만 수정합니다.</p>
     * */
    @Transactional
    public void saveUserWrongGrammars(WrongGrammarsDto wrongGrammarsDto) {
        SiteUser user = this.userService.getByUserName(wrongGrammarsDto.getUserName());
        Long grammarBookId = this.grammarBookService.getGrammarBookIdByGrammarBookName(wrongGrammarsDto.getGrammarBookName());
        List<UserWrongGrammar> userWrongGrammars = this.userWrongGrammarRepository.findByUserIdAndGrammarBookId(user.getId(), grammarBookId);

        if (userWrongGrammars.isEmpty()) {
            for (Long wrongGrammarId : wrongGrammarsDto.getWrongGrammarIds()) {
                saveNewUserWrongGrammar(user, wrongGrammarId, wrongGrammarsDto.getLastTryTime());
            }
        } else {
            updateUserWrongGrammars(user, wrongGrammarsDto, userWrongGrammars);
        }
    }

    private void updateUserWrongGrammars(SiteUser user, WrongGrammarsDto wrongGrammarsDto, List<UserWrongGrammar> userWrongGrammars) {
        //3-2부터
        Set<Long> wrongGrammarIds = new HashSet<>(wrongGrammarsDto.getWrongGrammarIds());
        Set<Long> userGrammarStatusWrongGrammarIds = collectWrongGrammarIds(userWrongGrammars);

        //DTO - entity 차집합 : 저장
        for (Long id : wrongGrammarIds){
            if (!userGrammarStatusWrongGrammarIds.contains(id)) {
                saveNewUserWrongGrammar(user, id, wrongGrammarsDto.getLastTryTime());
            }
        }

        //entity - DTO 차집합 : 삭제
        for (Long id : userGrammarStatusWrongGrammarIds) {
            if (!wrongGrammarIds.contains(id)) {
                this.userWrongGrammarRepository.deleteById(id);
            }
        }

        //교집합 : 수정
        for (UserWrongGrammar userWrongGrammar : userWrongGrammars) {
            if (wrongGrammarIds.contains(userWrongGrammar.getWrongGrammarId())) {
                userWrongGrammar.updateLastTryTime(wrongGrammarsDto.getLastTryTime());
            }
        }
    }

    private void saveNewUserWrongGrammar(SiteUser user, Long wrongGrammarId, LocalDateTime lastTryTime) {
        this.userWrongGrammarRepository.save(UserWrongGrammar.builder()
                .user(user)
                .wrongGrammarId(wrongGrammarId)
                .grammarBookId(this.grammarService.getGrammarBookIdByGrammarId(wrongGrammarId))
                .lastTryTime(lastTryTime)
                .build());
    }

    @Transactional
    public void updateUserLastTryTime(WrongGrammarsDto wrongGrammarsDto) {
        Long userId = getUserIdByUserName(wrongGrammarsDto.getUserName());

        List<UserWrongGrammar> userWrongGrammars = this.userWrongGrammarRepository.findByUserId(userId);

        for (UserWrongGrammar userWrongGrammar : userWrongGrammars) {
            userWrongGrammar.updateLastTryTime(wrongGrammarsDto.getLastTryTime());
        }
    }

    @Transactional
    public void deleteUserWrongGrammars(WrongGrammarsDto wrongGrammarsDto) {
        //user_name, grammar_id 에 해당하는 레코드 제거
        Long userId = getUserIdByUserName(wrongGrammarsDto.getUserName());

        for (Long grammarId : wrongGrammarsDto.getWrongGrammarIds()) {
            UserWrongGrammar userWrongGrammar = this.userWrongGrammarRepository.findByUserIdAndWrongGrammarId(userId, grammarId)
                    .orElseThrow(() -> new DataNotFoundException("UserGrammarStatus not found"));
            this.userWrongGrammarRepository.deleteById(userWrongGrammar.getId());
        }
    }

    private Set<Long> collectWrongGrammarIds(List<UserWrongGrammar> userWrongGrammars) {
        Set<Long> wrongGrammarIds = new HashSet<>();
        for (UserWrongGrammar userWrongGrammar : userWrongGrammars) {
            wrongGrammarIds.add(userWrongGrammar.getWrongGrammarId());
        }
        return wrongGrammarIds;
    }

    private Long getUserIdByUserName(String userName) {
        return this.userService.getByUserName(userName).getId();
    }
}
