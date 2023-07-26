package com.elsprage.paper.model.dto;

import com.elsprage.paper.persistance.entity.ErrorLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaperErrorDTO {
    private Long id;
    private Long resultId;
    private String wrong;
    private String corrected;
    private String explanation;
    private ErrorLevel errorLevel;
}
