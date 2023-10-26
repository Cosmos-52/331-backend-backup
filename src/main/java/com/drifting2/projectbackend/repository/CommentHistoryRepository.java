package com.drifting2.projectbackend.repository;

import com.drifting2.projectbackend.entity.CommentHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentHistoryRepository extends JpaRepository<CommentHistory,Long> {
    List<CommentHistory> findAll();
    Page<CommentHistory> findByAdvisorIdAndAdviseeId(Long advisorId, Long adviseeId, Pageable pageRequest);

}