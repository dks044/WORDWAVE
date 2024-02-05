package com.wordwave.grammar;

import com.wordwave.user.UserService;
import com.wordwave.util.ResponseDTO;
import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.WrongGrammarsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * userName으로 User를 조회합니다.
     * */
    @Transactional
    public void saveUserWrongGrammars(WrongGrammarsDto wrongGrammarsDto) {
        for (Long wrongGrammarId : wrongGrammarsDto.getWrongGrammarIds()) {
            this.userGrammarStatusRepository.save(UserGrammarStatus.builder()
                    .user(this.userService.getByUserName(wrongGrammarsDto.getUserName()))
                    .wrongGrammarId(wrongGrammarId)
                    .lastTryTime(wrongGrammarsDto.getLastTryTime())
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
