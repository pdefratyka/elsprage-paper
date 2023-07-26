package com.elsprage.paper.model.response;

import com.elsprage.paper.model.dto.TopicDTO;

import java.util.List;

public record TopicsResponse(List<TopicDTO> topics) {
}
