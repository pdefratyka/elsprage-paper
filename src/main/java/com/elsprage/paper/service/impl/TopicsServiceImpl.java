package com.elsprage.paper.service.impl;

import com.elsprage.paper.common.exception.TopicException;
import com.elsprage.paper.common.mapper.TagMapper;
import com.elsprage.paper.model.dto.TopicDTO;
import com.elsprage.paper.model.request.TopicRequest;
import com.elsprage.paper.persistance.entity.Tag;
import com.elsprage.paper.persistance.entity.Topic;
import com.elsprage.paper.persistance.repository.TopicsRepository;
import com.elsprage.paper.service.JwtService;
import com.elsprage.paper.service.TagsService;
import com.elsprage.paper.service.TopicsService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class TopicsServiceImpl implements TopicsService {

    private final TopicsRepository topicsRepository;
    private final TagsService tagsService;
    private final JwtService jwtService;

    @Override
    public List<TopicDTO> getAllTopicsByUserId(String token) {
        long userId = jwtService.extractUserId(token);
        log.info("Get topics for user with id: {}", userId);
        List<Topic> topics = topicsRepository.findAllByUserId(userId);
        return topics.stream()
                .map(topic -> new TopicDTO(topic.getId(), topic.getValue(), TagMapper.mapToListTagDTO(topic.getTags())))
                .toList();
    }

    @Override
    public TopicDTO saveTopic(final TopicRequest topicRequest, String token) {
        log.info("Save topic: {}", topicRequest);
        final Set<Tag> tags = tagsService.getTagsByIds(topicRequest.getTagsIds());
        final Topic topic = Topic.builder()
                .value(topicRequest.getValue())
                .userId(jwtService.extractUserId(token))
                .tags(tags)
                .build();
        final Topic savedTopic = topicsRepository.save(topic);
        return new TopicDTO(savedTopic.getId(), savedTopic.getValue(), TagMapper.mapToListTagDTO(savedTopic.getTags()));
    }

    @Override
    public void deleteTopic(Long topicId, String token) {
        log.info("Delete topic with id: {}", topicId);
        final long userId = jwtService.extractUserId(token);
        final Optional<Topic> topic = topicsRepository.findFirstByIdAndUserId(topicId, userId);
        if (topic.isEmpty()) {
            throw new TopicException.TopicDoesNotExistException(topicId);
        }
        topicsRepository.delete(topic.get());
    }
}
