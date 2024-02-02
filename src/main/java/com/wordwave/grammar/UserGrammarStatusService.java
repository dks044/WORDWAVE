package com.wordwave.grammar;

import com.wordwave.util.ResponseDTO;
import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.WrongGrammarDto;
import com.wordwave.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGrammarStatusService {
    private final UserGrammarStatusRepository userGrammarStatusRepository;
    private final UserRepository userRepository;
    private final GrammarService grammarService;


    public void saveUserWrongGrammars(WrongGrammarDto wrongGrammarDto) {
        for (Long wrongGrammarId : wrongGrammarDto.getWrongGrammarIds()) {
            this.userGrammarStatusRepository.save(UserGrammarStatus.builder()
                    //보안 dev push전까진 user 생략
                    .wrongGrammarId(wrongGrammarId)
                    .lastAttempted(wrongGrammarDto.getLastAttempted())
                    .build());
        }
    }

    @Transactional
    public ResponseDTO<Object> getUserWrongGrammars(String userName) {
        //userName으로 User 레코드를 찾고 해당 User의 id로 UserGrammarStatus를 가져온다.
        Long userId = this.userRepository.findByUserName(userName).getId();

        List<UserGrammarStatus> userGrammarStatuses = this.userGrammarStatusRepository.findByUserId(userId)
                .orElseThrow(() -> new DataNotFoundException("No userGrammarStatus matching user."));

        List<GrammarDto> grammarDtos = new ArrayList<>();
        for (UserGrammarStatus userGrammarStatus : userGrammarStatuses) {
            grammarDtos.add(grammarService.getGrammar(userGrammarStatus.getWrongGrammarId()));
        }
        return ResponseDTO.builder()
                .data(grammarDtos)
                .build();
    }
}
