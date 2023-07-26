package com.elsprage.paper.persistance.repository;

import com.elsprage.paper.persistance.entity.PaperError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperErrorRepository extends JpaRepository<PaperError, Long> {
}
