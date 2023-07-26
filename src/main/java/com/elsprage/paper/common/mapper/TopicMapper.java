package com.elsprage.paper.common.mapper;

import com.elsprage.paper.model.dto.TopicDTO;
import com.elsprage.paper.persistance.entity.Topic;

public final class TopicMapper {

    public static TopicDTO mapToTopicDTO(final Topic topic) {
        if (topic == null) {
            return null;
        }
        return TopicDTO.builder()
                .id(topic.getId())
                .value(topic.getValue())
                .tags(TagMapper.mapToListTagDTO(topic.getTags()))
                .build();
    }
}
