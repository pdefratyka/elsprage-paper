package com.elsprage.paper.common.mapper;

import com.elsprage.paper.model.dto.PaperErrorDTO;
import com.elsprage.paper.persistance.entity.PaperError;

import java.util.List;

public class PaperErrorMapper {

    public static PaperErrorDTO mapToPaperErrorDTO(final PaperError paperError) {
        return PaperErrorDTO.builder()
                .id(paperError.getId())
                .wrong(paperError.getWrong())
                .corrected(paperError.getCorrected())
                .resultId(paperError.getResultId())
                .explanation(paperError.getExplanation())
                .errorLevel(paperError.getErrorLevel())
                .build();
    }

    public static PaperError mapToPaperError(final PaperErrorDTO paperErrorDTO) {
        return PaperError.builder()
                .id(paperErrorDTO.getId())
                .wrong(paperErrorDTO.getWrong())
                .corrected(paperErrorDTO.getCorrected())
                .resultId(paperErrorDTO.getResultId())
                .explanation(paperErrorDTO.getExplanation())
                .errorLevel(paperErrorDTO.getErrorLevel())
                .build();
    }

    public static List<PaperErrorDTO> mapToPaperErrorDTOList(final List<PaperError> paperErrors) {
        if (paperErrors == null) {
            return List.of();
        }
        return paperErrors.stream().map(PaperErrorMapper::mapToPaperErrorDTO).toList();
    }

    public static List<PaperError> mapToPaperErrorList(final List<PaperErrorDTO> paperErrors) {
        if (paperErrors == null) {
            return List.of();
        }
        return paperErrors.stream().map(PaperErrorMapper::mapToPaperError).toList();
    }
}
