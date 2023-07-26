package com.elsprage.paper.service;

import com.elsprage.paper.model.dto.TagDTO;
import com.elsprage.paper.model.request.TagRequest;
import com.elsprage.paper.persistance.entity.Tag;

import java.util.List;
import java.util.Set;

public interface TagsService {
    List<TagDTO> getAllTags(String authToken);

    TagDTO saveTag(TagRequest tagRequest, String authToken);

    Set<Tag> getTagsByIds(List<Long> tagsIds);

    void deleteTag(long tagId, String token);
}
