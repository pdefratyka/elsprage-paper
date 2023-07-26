package com.elsprage.paper.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PaperResultDTO {
    private Long id;
    private String paperText;
    private String refactoredText;
    private Long topicId;
    private TopicDTO topic;
    private String language;
    private Long paperModeId;
    private PaperModeDTO paperMode;
    private BigDecimal score;
    private Long userId;
    private LocalDateTime date;
    private Long numberOfWords;
    private Long numberOfCharacters;
    private List<PaperErrorDTO> paperErrors;
}
