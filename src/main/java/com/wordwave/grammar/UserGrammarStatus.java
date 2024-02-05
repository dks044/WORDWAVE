package com.wordwave.grammar;

import com.wordwave.user.SiteUser;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class UserGrammarStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private SiteUser user;

    /**
     * Grammar 엔티티에서 UserGrammarStatus의 PK가 아닌 FK인 user를 참조해야하므로 ORM 설계 관점에서 좋지 않다.
     * 게다가 Grammar에서는 레코드당 여러 user를 매핑해야하는데,
     * 이는 UserGrammarStatus에서 user 한 명당 여러 Grammar를 매핑해야하는 상황과 정반대다.
     * 이는 N:N 관계로 풀 수 있겠지만 쓸데없이 복잡해진다는 단점이 있다.
     * <p>그래서 연관관계를 설정해주는 대신 클라이언트로부터 grammar_id를 받아와 저장하고 필요할때 Grammar에 join한다.
     * <p>user 한 명당 grammar_id는 여러 개가 저장될 수 있다.
     */
    private Long wrongGrammarId;

    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime lastTryTime;

    public void updateLastTryTime(LocalDateTime lastTryTime) {
        this.lastTryTime = lastTryTime;
    }

    @Builder
    public UserGrammarStatus(SiteUser user, Long wrongGrammarId, LocalDateTime lastTryTime) {
        this.user = user;
        this.wrongGrammarId = wrongGrammarId;
        this.lastTryTime = lastTryTime;
    }
}
