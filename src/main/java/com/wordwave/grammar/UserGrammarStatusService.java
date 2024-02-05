package com.wordwave.grammar;

import com.wordwave.user.SiteUser;
import com.wordwave.user.UserService;
import com.wordwave.util.ResponseDTO;
import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.WrongGrammarsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserGrammarStatusService {
    private final UserGrammarStatusRepository userGrammarStatusRepository;
    private final GrammarService grammarService;
    private final UserService userService;

    /**
     * userName으로 userGrammarStatuses레코드들을 조회한 뒤,
     * 저장된 Grammar의 id들로 Grammar레코드를 가져옵니다.
     * 이 들과 lastTryTime을 Map에 넣어 반환합니다.
     * */
    @Transactional
    public ResponseDTO<Object> getUserWrongGrammars(String userName) {
        Long userId = getUserIdByUserName(userName);
        List<UserGrammarStatus> userGrammarStatuses = this.userGrammarStatusRepository.findByUserId(userId);

        Map<String, Object> response = new HashMap<>();
        List<GrammarDto> wrongGrammars = new ArrayList<>();
        for (UserGrammarStatus userGrammarStatus : userGrammarStatuses) {
            wrongGrammars.add(grammarService.getGrammar(userGrammarStatus.getWrongGrammarId()));
        }
        response.put("wrongGrammars", wrongGrammars);
        response.put("lastTryTime", userGrammarStatuses.get(userGrammarStatuses.size()-1).getLastTryTime());
        return ResponseDTO.builder()
                .data(response)
                .build();
    }

    /**
     * userName과 wrongGrammarIds를 받아 저장합니다.
     * userName으로 User를 조회한 뒤, UserGrammarStatus를 조회하고 이미 UserGrammarStatus에 있는 User라면
     * wrongGrammarIds의 GrammarId와 같은 레코드들은 lastTryTime만 수정하고, 같지 않은 GrammarId들은 저장합니다.
     * UserGrammarStatus에 없는 User라면, 받은 wrongGrammarIds들을 모두 저장합니다.
     * */
    @Transactional
    public void saveUserWrongGrammars(WrongGrammarsDto wrongGrammarsDto) {
        SiteUser user = this.userService.getByUserName(wrongGrammarsDto.getUserName());
        List<UserGrammarStatus> userGrammarStatuses = this.userGrammarStatusRepository.findByUserId(user.getId());
        if (userGrammarStatuses.isEmpty()) {
            saveNewUserWrongGrammar(user, wrongGrammarsDto.getWrongGrammarIds(), wrongGrammarsDto.getLastTryTime());
        } else {
            updateAndSaveUserWrongGrammars(user, wrongGrammarsDto, userGrammarStatuses);
        }
    }

    private void updateAndSaveUserWrongGrammars(SiteUser user, WrongGrammarsDto wrongGrammarsDto, List<UserGrammarStatus> userGrammarStatuses) {
        List<Long> wrongGrammarIds = wrongGrammarsDto.getWrongGrammarIds();
        for (UserGrammarStatus userGrammarStatus : userGrammarStatuses) {
            if (wrongGrammarIds.contains(userGrammarStatus.getWrongGrammarId())) {
                userGrammarStatus.updateLastTryTime(wrongGrammarsDto.getLastTryTime());
                this.userGrammarStatusRepository.save(userGrammarStatus);
            }
        }
        List<Long> userGrammarStatusWrongGrammarIds = makeUserGrammarStatusWrongGrammarIds(userGrammarStatuses);
        for (Long grammarId : wrongGrammarIds) {
            if (!userGrammarStatusWrongGrammarIds.contains(grammarId)) {
                this.userGrammarStatusRepository.save(UserGrammarStatus.builder()
                        .user(user)
                        .wrongGrammarId(grammarId)
                        .lastTryTime(wrongGrammarsDto.getLastTryTime())
                        .build());
            }
        }
    }

    private List<Long> makeUserGrammarStatusWrongGrammarIds(List<UserGrammarStatus> userGrammarStatuses) {
        List<Long> userGrammarStatusWrongGrammarIds = new ArrayList<>();
        for (UserGrammarStatus userGrammarStatus : userGrammarStatuses) {
            userGrammarStatusWrongGrammarIds.add(userGrammarStatus.getWrongGrammarId());
        }
        return userGrammarStatusWrongGrammarIds;
    }

    private void saveNewUserWrongGrammar(SiteUser user, List<Long> wrongGrammarIds, LocalDateTime lastTryTime) {
        for (Long wrongGrammarId : wrongGrammarIds) {
            this.userGrammarStatusRepository.save(UserGrammarStatus.builder()
                    .user(user)
                    .wrongGrammarId(wrongGrammarId)
                    .lastTryTime(lastTryTime)
                    .build());
        }
    }

    @Transactional
    public void updateUserLastTryTime(WrongGrammarsDto wrongGrammarsDto) {
        Long userId = getUserIdByUserName(wrongGrammarsDto.getUserName());

        List<UserGrammarStatus> userGrammarStatuses = this.userGrammarStatusRepository.findByUserId(userId);

        for (UserGrammarStatus userGrammarStatus : userGrammarStatuses) {
            userGrammarStatus.updateLastTryTime(wrongGrammarsDto.getLastTryTime());
        }
    }

    @Transactional
    public void deleteUserWrongGrammars(WrongGrammarsDto wrongGrammarsDto) {
        //user_name, grammar_id 에 해당하는 레코드 제거
        Long userId = getUserIdByUserName(wrongGrammarsDto.getUserName());

        for (Long grammarId : wrongGrammarsDto.getWrongGrammarIds()) {
            UserGrammarStatus userGrammarStatus = this.userGrammarStatusRepository.findByUserIdAndWrongGrammarId(userId, grammarId)
                    .orElseThrow(() -> new DataNotFoundException("UserGrammarStatus not found"));
            this.userGrammarStatusRepository.deleteById(userGrammarStatus.getId());
        }
    }

    private Long getUserIdByUserName(String userName) {
        return this.userService.getByUserName(userName).getId();
    }
}
