package com.elsprage.paper.common.mapper;

import com.elsprage.paper.model.dto.TagDTO;
import com.elsprage.paper.persistance.entity.Tag;

import java.util.List;
import java.util.Set;

public final class TagMapper {

    public static TagDTO mapToTagDTO(Tag tag) {
        return TagDTO.builder()
                .id(tag.getId())
                .userId(tag.getUserId())
                .value(tag.getValue())
                .build();
    }

    public static List<TagDTO> mapToListTagDTO(List<Tag> tags) {
        return tags.stream()
                .map(TagMapper::mapToTagDTO)
                .toList();
    }

    public static List<TagDTO> mapToListTagDTO(Set<Tag> tags) {
        return tags.stream()
                .map(TagMapper::mapToTagDTO)
                .toList();
    }
}
