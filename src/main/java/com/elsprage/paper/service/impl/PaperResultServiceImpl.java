package com.elsprage.paper.service.impl;

import com.elsprage.paper.common.exception.ResultException;
import com.elsprage.paper.common.mapper.PaperResultMapper;
import com.elsprage.paper.model.dto.PaperResultDTO;
import com.elsprage.paper.model.request.PaperResultRequest;
import com.elsprage.paper.model.response.PaperResultsResponse;
import com.elsprage.paper.persistance.entity.PaperError;
import com.elsprage.paper.persistance.entity.PaperResult;
import com.elsprage.paper.persistance.repository.PaperErrorRepository;
import com.elsprage.paper.persistance.repository.PaperResultRepository;
import com.elsprage.paper.service.JwtService;
import com.elsprage.paper.service.PaperResultService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class PaperResultServiceImpl implements PaperResultService {

    private final JwtService jwtService;
    private final PaperResultRepository paperResultRepository;
    private final PaperErrorRepository paperErrorRepository;

    @Override
    public PaperResultDTO savePaperResult(PaperResultRequest paperResultRequest, String token) {
        final Long userId = jwtService.extractUserId(token);
        final PaperResult paperResult = PaperResultMapper.mapToPaperResult(paperResultRequest, userId);
        log.info("Save paper result: {}", paperResult);
        final PaperResult savedPaperResult = paperResultRepository.save(paperResult);
        final List<PaperError> paperErrors = paperResult.getPaperErrors();
        paperErrors.forEach(p -> p.setResultId(savedPaperResult.getId()));
        paperErrorRepository.saveAll(paperErrors);
        return PaperResultMapper.mapToPaperResultDTO(savedPaperResult);
    }

    @Override
    public PaperResultsResponse getPaperResultsForUser(String token) {
        final Long userId = jwtService.extractUserId(token);
        final List<PaperResult> paperResults = paperResultRepository.findByUserId(userId);
        final List<PaperResultDTO> paperResultDTOList = PaperResultMapper.mapToPaperResultDTOList(paperResults);
        return new PaperResultsResponse(paperResultDTOList);
    }

    @Override
    public PaperResultDTO getPaperResultById(String token, Long id) {
        final Long userId = jwtService.extractUserId(token);
        final Optional<PaperResult> paperResult = paperResultRepository.findByIdAndUserId(id, userId);
        if (paperResult.isEmpty()) {
            throw new ResultException.ResultNotFoundException(id);
        }
        return PaperResultMapper.mapToPaperResultDTO(paperResult.get());
    }
}
