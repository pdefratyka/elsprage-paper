package com.elsprage.paper.persistance.repository;

import com.elsprage.paper.persistance.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findAllByUserId(Long userId);

    Optional<Tag> findFirstByIdAndUserId(long id, long userId);
}
