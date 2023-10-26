package com.drifting2.projectbackend.service;


import com.drifting2.projectbackend.entity.CommentHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentHistoryService {
    Integer getCommentHistorySize();
    Page<CommentHistory> getCommentHistory(Integer pageSize, Integer page);
    CommentHistory getCommentHistory(Long id);
    CommentHistory save(CommentHistory student);
    Page<CommentHistory> getCommentHistory(Integer advisorId, Integer adviseeId, Pageable pageable);
}
