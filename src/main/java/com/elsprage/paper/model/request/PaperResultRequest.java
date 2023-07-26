package com.elsprage.paper.model.request;

import com.elsprage.paper.model.dto.PaperErrorDTO;

import java.util.List;

public record PaperResultRequest(String paperText, String refactoredText, Long topicId, String language,
                                 Long paperModeId, List<PaperErrorDTO> paperErrors) {
}
