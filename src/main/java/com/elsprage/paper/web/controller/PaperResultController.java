package com.elsprage.paper.web.controller;

import com.elsprage.paper.model.dto.PaperResultDTO;
import com.elsprage.paper.model.request.PaperResultRequest;
import com.elsprage.paper.model.response.PaperResultsResponse;
import com.elsprage.paper.service.PaperResultService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paper/results")
@AllArgsConstructor
public class PaperResultController {

    private final PaperResultService paperResultService;

    @PostMapping
    public PaperResultDTO savePaperResult(@RequestBody PaperResultRequest paperResultRequest, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return paperResultService.savePaperResult(paperResultRequest, token);
    }

    @GetMapping
    public PaperResultsResponse getPaperResults(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return paperResultService.getPaperResultsForUser(token);
    }

    @GetMapping("/{id}")
    public PaperResultDTO getPaperResults(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable Long id) {
        return paperResultService.getPaperResultById(token, id);
    }
}
