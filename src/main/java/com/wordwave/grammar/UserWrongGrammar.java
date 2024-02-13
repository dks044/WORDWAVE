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
public class UserWrongGrammar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private SiteUser user;

    @Column(nullable = false)
    private Long wrongGrammarId;

    private Long grammarBookId;

    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime lastTryTime;

    public void updateLastTryTime(LocalDateTime lastTryTime) {
        this.lastTryTime = lastTryTime;
    }

    @Builder
    public UserWrongGrammar(SiteUser user, Long wrongGrammarId, Long grammarBookId, LocalDateTime lastTryTime) {
        this.user = user;
        this.wrongGrammarId = wrongGrammarId;
        this.grammarBookId = grammarBookId;
        this.lastTryTime = lastTryTime;
    }
}
