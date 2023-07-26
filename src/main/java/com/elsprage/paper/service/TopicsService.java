package com.elsprage.paper.service;

import com.elsprage.paper.model.dto.TopicDTO;
import com.elsprage.paper.model.request.TopicRequest;

import java.util.List;

public interface TopicsService {
    List<TopicDTO> getAllTopicsByUserId(String token);

    TopicDTO saveTopic(TopicRequest topicRequest, String token);

    void deleteTopic(Long topicId, String token);
}
