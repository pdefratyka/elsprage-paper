package com.elsprage.paper.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paper_errors")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaperError {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "result_id")
    private Long resultId;
    @Column(name = "wrong")
    private String wrong;
    @Column(name = "corrected")
    private String corrected;
    @Column(name = "explanation")
    private String explanation;
    @Enumerated(EnumType.STRING)
    @Column(name = "error_level")
    private ErrorLevel errorLevel;
}
