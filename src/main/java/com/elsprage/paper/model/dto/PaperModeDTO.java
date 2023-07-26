package com.elsprage.paper.model.dto;

import lombok.Builder;

@Builder
public record PaperModeDTO(Long id, String name, Long numberOfWords, Long durationInMinutes) {
}
