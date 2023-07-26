package com.elsprage.paper.web.controller;

import com.elsprage.paper.model.dto.TagDTO;
import com.elsprage.paper.model.request.TagRequest;
import com.elsprage.paper.model.response.TagsResponse;
import com.elsprage.paper.service.TagsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paper/tags")
@AllArgsConstructor
public class TagsController {

    private final TagsService tagsService;

    @GetMapping
    public TagsResponse getTags(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return new TagsResponse(tagsService.getAllTags(token));
    }

    @PostMapping
    public TagDTO saveTag(@RequestBody TagRequest tagRequest, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return tagsService.saveTag(tagRequest, token);
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        tagsService.deleteTag(id,token);
    }
}
