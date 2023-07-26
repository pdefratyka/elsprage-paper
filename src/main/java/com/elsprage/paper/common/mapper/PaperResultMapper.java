package com.elsprage.paper.common.mapper;

import com.elsprage.paper.model.dto.PaperResultDTO;
import com.elsprage.paper.model.request.PaperResultRequest;
import com.elsprage.paper.persistance.entity.PaperResult;
import io.micrometer.common.util.StringUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PaperResultMapper {

    public static PaperResult mapToPaperResult(final PaperResultRequest paperResultRequest, final Long userId) {
        return PaperResult.builder()
                .paperText(paperResultRequest.paperText())
                .refactoredText(paperResultRequest.refactoredText())
                .language(paperResultRequest.language())
                .topicId(paperResultRequest.topicId())
                .paperModeId(paperResultRequest.paperModeId())
                .userId(userId)
                .date(LocalDateTime.now())
                .paperErrors(PaperErrorMapper.mapToPaperErrorList(paperResultRequest.paperErrors()))
                .build();
    }

    public static PaperResultDTO mapToPaperResultDTO(final PaperResult paperResult) {
        return PaperResultDTO.builder()
                .id(paperResult.getId())
                .paperText(paperResult.getPaperText())
                .refactoredText(paperResult.getRefactoredText())
                .language(paperResult.getLanguage())
                .score(paperResult.getScore())
                .topicId(paperResult.getTopicId())
                .topic(TopicMapper.mapToTopicDTO(paperResult.getTopic()))
                .paperModeId(paperResult.getPaperModeId())
                .paperMode(PaperModeMapper.mapToPaperModeDTO(paperResult.getPaperMode()))
                .userId(paperResult.getUserId())
                .date(paperResult.getDate())
                .numberOfWords(getNumberOfWords(paperResult.getPaperText()))
                .numberOfCharacters(getNumberOfCharacters(paperResult.getPaperText()))
                .paperErrors(PaperErrorMapper.mapToPaperErrorDTOList(paperResult.getPaperErrors()))
                .build();
    }

    public static List<PaperResultDTO> mapToPaperResultDTOList(final List<PaperResult> paperResults) {
        return paperResults.stream()
                .map(PaperResultMapper::mapToPaperResultDTO)
                .collect(Collectors.toList());
    }

    private static long getNumberOfWords(final String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }
        return text.split(" ").length;
    }

    private static long getNumberOfCharacters(final String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }
        return text.length();
    }
}
