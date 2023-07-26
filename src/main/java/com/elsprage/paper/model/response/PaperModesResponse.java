package com.elsprage.paper.model.response;

import com.elsprage.paper.model.dto.PaperModeDTO;

import java.util.List;

public record PaperModesResponse(List<PaperModeDTO> paperModes) {
}
