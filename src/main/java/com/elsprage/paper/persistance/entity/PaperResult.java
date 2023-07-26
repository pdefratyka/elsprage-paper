package com.elsprage.paper.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "paper_results")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaperResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "topic_id")
    private Long topicId;
    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false, insertable = false, updatable = false)
    private Topic topic;
    @Column(name = "paper_mode_id")
    private Long paperModeId;
    @ManyToOne
    @JoinColumn(name = "paper_mode_id", nullable = false, insertable = false, updatable = false)
    private PaperMode paperMode;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "language")
    private String language;
    @Column(name = "paper_text")
    private String paperText;
    @Column(name = "refactored_text")
    private String refactoredText;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "score")
    private BigDecimal score;
    @OneToMany(mappedBy = "resultId")
    private List<PaperError> paperErrors;
}
