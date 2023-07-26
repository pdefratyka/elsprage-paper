package com.elsprage.paper.web.controller;

import com.elsprage.paper.model.dto.TopicDTO;
import com.elsprage.paper.model.request.TopicRequest;
import com.elsprage.paper.model.response.TopicsResponse;
import com.elsprage.paper.service.TopicsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paper/topics")
@AllArgsConstructor
public class TopicsController {

    private final TopicsService topicsService;

    @GetMapping
    public TopicsResponse getTopics(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return new TopicsResponse(topicsService.getAllTopicsByUserId(token));
    }

    @PostMapping
    public TopicDTO saveTopic(@RequestBody TopicRequest topicRequest, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return topicsService.saveTopic(topicRequest, token);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        topicsService.deleteTopic(id,token);
    }
}
