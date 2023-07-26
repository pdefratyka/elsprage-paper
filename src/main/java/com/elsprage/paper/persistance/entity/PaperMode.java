package com.elsprage.paper.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paper_mode")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaperMode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "number_of_words")
    private Long numberOfWords;
    @Column(name = "duration_in_minutes")
    private Long durationInMinutes;
}
