package com.elsprage.paper.model.response;

import com.elsprage.paper.model.dto.PaperResultDTO;

import java.util.List;

public record PaperResultsResponse(List<PaperResultDTO> paperResults) {
}
