package com.elsprage.paper.persistance.repository;

import com.elsprage.paper.persistance.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicsRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAllByUserId(long userId);

    Optional<Topic> findFirstByIdAndUserId(long id, long userId);
}
