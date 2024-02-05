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
     * Grammar 엔티티에서 UserGrammarStatus의 PK가 아닌 FK인 user를 참조해야하므로 ORM 설계 관점에서 좋지 않습니다.
     * 게다가 Grammar에서는 레코드당 여러 user를 매핑해야하는데,
     * 반대로 UserGrammarStatus에서는 user 한 명당 여러 Grammar를 매핑해야 합니다.
     * 이는 N:N 관계로 풀 수 있지만 쓸데없이 복잡해집니다.
     * <p>그래서 연관관계를 설정해주는 대신 클라이언트로부터 grammarId를 받아와 저장하고 필요할때 Grammar에 join합니다.
     * <p>user 한 명당 grammarId는 여러 개가 저장될 수 있지만, 한 명의 user가 중복되는 grammarId를 가질 수 없습니다.
     * <p>grammarBookId도 같은 개념을 적용하며, grammarId를 저장할때 grammar로부터 불러와 grammarBookId를 저장합니다.
     */
    @Column(unique = true)
    private Long wrongGrammarId;

    private Long grammarBookId;

    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime lastTryTime;

    public void updateLastTryTime(LocalDateTime lastTryTime) {
        this.lastTryTime = lastTryTime;
    }

    @Builder
    public UserGrammarStatus(SiteUser user, Long wrongGrammarId, Long grammarBookId, LocalDateTime lastTryTime) {
        this.user = user;
        this.wrongGrammarId = wrongGrammarId;
        this.grammarBookId = grammarBookId;
        this.lastTryTime = lastTryTime;
    }
}
