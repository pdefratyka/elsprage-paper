package com.elsprage.paper.model.response;

import com.elsprage.paper.model.dto.TagDTO;

import java.util.List;

public record TagsResponse(List<TagDTO> tags) {
}
