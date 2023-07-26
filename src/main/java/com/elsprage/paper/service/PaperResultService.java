package com.elsprage.paper.service;

import com.elsprage.paper.model.dto.PaperResultDTO;
import com.elsprage.paper.model.request.PaperResultRequest;
import com.elsprage.paper.model.response.PaperResultsResponse;

public interface PaperResultService {
    PaperResultDTO savePaperResult(PaperResultRequest paperResultRequest, String token);
    PaperResultsResponse getPaperResultsForUser(String token);

    PaperResultDTO getPaperResultById(String token, Long id);
}
