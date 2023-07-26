package com.elsprage.paper.web.controller;

import com.elsprage.paper.model.response.PaperModesResponse;
import com.elsprage.paper.service.PaperModeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paper/modes")
@AllArgsConstructor
public class PaperModeController {

    private final PaperModeService paperModeService;

    @GetMapping
    public PaperModesResponse getPaperModes() {
        return new PaperModesResponse(paperModeService.getPaperModes());
    }
}
