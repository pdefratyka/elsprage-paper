package com.elsprage.paper.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TopicDTO {
    private Long id;
    private String value;
    private List<TagDTO> tags;
}
