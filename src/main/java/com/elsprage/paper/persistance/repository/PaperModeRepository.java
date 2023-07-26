package com.elsprage.paper.persistance.repository;

import com.elsprage.paper.persistance.entity.PaperMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperModeRepository extends JpaRepository<PaperMode, Long> {
}
