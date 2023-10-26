package com.drifting2.projectbackend.service;


import com.drifting2.projectbackend.entity.CommentMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentMessageService {
    Integer getCommentMessageSize();
    Page<CommentMessage> getCommentMessages(Integer pageSize, Integer page);
    CommentMessage getCommentMessage(Long id);
    CommentMessage save(CommentMessage teacher);
    Page<CommentMessage> getCommentMessages(String title, Pageable pageable);
}
