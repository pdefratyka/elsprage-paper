package com.elsprage.paper.persistance.repository;

import com.elsprage.paper.persistance.entity.PaperResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaperResultRepository extends JpaRepository<PaperResult, Long> {
    List<PaperResult> findByUserId(long userId);

    Optional<PaperResult> findByIdAndUserId(long id, long userId);
}
