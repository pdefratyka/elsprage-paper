package com.elsprage.paper.common.mapper;

import com.elsprage.paper.model.dto.PaperModeDTO;
import com.elsprage.paper.persistance.entity.PaperMode;

import java.util.List;

public final class PaperModeMapper {

    public static PaperModeDTO mapToPaperModeDTO(final PaperMode paperMode) {
        if(paperMode==null){
            return null;
        }
        return PaperModeDTO.builder()
                .id(paperMode.getId())
                .name(paperMode.getName())
                .durationInMinutes(paperMode.getDurationInMinutes())
                .numberOfWords(paperMode.getNumberOfWords())
                .build();
    }

    public static List<PaperModeDTO> mapToPaperModeDTOList(final List<PaperMode> paperModes) {
        if (paperModes == null) {
            return List.of();
        }
        return paperModes.stream().map(PaperModeMapper::mapToPaperModeDTO).toList();
    }
}
