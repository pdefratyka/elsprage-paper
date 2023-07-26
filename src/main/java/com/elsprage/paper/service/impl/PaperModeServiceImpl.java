package com.elsprage.paper.service.impl;

import com.elsprage.paper.common.mapper.PaperModeMapper;
import com.elsprage.paper.model.dto.PaperModeDTO;
import com.elsprage.paper.persistance.entity.PaperMode;
import com.elsprage.paper.persistance.repository.PaperModeRepository;
import com.elsprage.paper.service.PaperModeService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Log4j2
@Service
public class PaperModeServiceImpl implements PaperModeService {

    private final PaperModeRepository paperModeRepository;

    @Override
    public List<PaperModeDTO> getPaperModes() {
        log.info("Get Paper Modes");
        final List<PaperMode> paperModes = paperModeRepository.findAll();
        return PaperModeMapper.mapToPaperModeDTOList(paperModes);
    }
}
