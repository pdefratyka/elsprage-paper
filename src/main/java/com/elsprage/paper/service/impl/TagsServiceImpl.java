package com.elsprage.paper.service.impl;

import com.elsprage.paper.common.exception.TagException;
import com.elsprage.paper.common.exception.TopicException;
import com.elsprage.paper.common.mapper.TagMapper;
import com.elsprage.paper.model.dto.TagDTO;
import com.elsprage.paper.model.request.TagRequest;
import com.elsprage.paper.persistance.entity.Tag;
import com.elsprage.paper.persistance.entity.Topic;
import com.elsprage.paper.persistance.repository.TagRepository;
import com.elsprage.paper.service.JwtService;
import com.elsprage.paper.service.TagsService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class TagsServiceImpl implements TagsService {

    private final JwtService jwtService;
    private final TagRepository tagRepository;

    @Override
    public List<TagDTO> getAllTags(String authToken) {
        final Long userId = jwtService.extractUserId(authToken);
        final List<Tag> tags = tagRepository.findAllByUserId(userId);
        return TagMapper.mapToListTagDTO(tags);
    }

    @Override
    public TagDTO saveTag(TagRequest tagRequest, String authToken) {
        final Long userId = jwtService.extractUserId(authToken);
        log.info("Save tag: {} for user with id: {}", tagRequest, userId);
        final Tag tag = Tag.builder()
                .value(tagRequest.getValue())
                .userId(userId)
                .build();
        return TagMapper.mapToTagDTO(tagRepository.save(tag));
    }

    @Override
    public Set<Tag> getTagsByIds(List<Long> tagsIds) {
        List<Tag> tags = tagRepository.findAllById(tagsIds);
        return new HashSet<>(tags);
    }

    @Override
    public void deleteTag(long tagId, String token) {
        log.info("Delete tag with id: {}", tagId);
        final long userId = jwtService.extractUserId(token);
        final Optional<Tag> topic = tagRepository.findFirstByIdAndUserId(tagId, userId);
        if (topic.isEmpty()) {
            throw new TagException.TagDoesNotExistException(tagId);
        }
        tagRepository.delete(topic.get());
    }
}
