package com.drifting2.projectbackend.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.drifting2.projectbackend.entity.CommentHistory;

public interface CommentHistoryDao {
    Integer getCommentHistorySize();
    Page<CommentHistory> getCommentHistory(Integer pageSize, Integer page);
    CommentHistory getCommentHistory(Long id);
    CommentHistory save(CommentHistory commentHistory);
    Page<CommentHistory> getCommentHistory(Integer advisorId, Integer adviseeId, Pageable page);
    Optional<CommentHistory> findById(Long id);
}
