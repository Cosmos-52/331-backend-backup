package com.drifting2.projectbackend.dao;

import com.drifting2.projectbackend.entity.CommentMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentMessageDao {
    Integer getCommentMessageSize();
    Page<CommentMessage> getCommentMessages(Integer pageSize, Integer page);
    CommentMessage getCommentMessage(Long id);
    CommentMessage save(CommentMessage commentMessage);
    Page<CommentMessage> getCommentMessages(String name, Pageable page);
}
