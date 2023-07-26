package com.elsprage.paper.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TopicRequest {
    private String value;
    private List<Long> tagsIds;
}
