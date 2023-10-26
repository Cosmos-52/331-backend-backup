package com.drifting2.projectbackend.service;

import com.drifting2.projectbackend.dao.CommentHistoryDao;
import com.drifting2.projectbackend.dao.CommentMessageDao;
import com.drifting2.projectbackend.entity.CommentHistory;
import com.drifting2.projectbackend.entity.CommentMessage;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class CommentMessageServiceImpl implements CommentMessageService{
    final CommentMessageDao commentMessageDao;
    final CommentHistoryDao commentHistoryDao;

    @Override
    public Integer getCommentMessageSize() {
        return commentMessageDao.getCommentMessageSize();
    }

    @Override
    public Page<CommentMessage> getCommentMessages(Integer pageSize, Integer page) {
        return commentMessageDao.getCommentMessages(pageSize, page);
    }

    @Override
    public CommentMessage getCommentMessage(Long id) {
        return commentMessageDao.getCommentMessage(id);
    }

    @Override
    @Transactional
    public CommentMessage save(CommentMessage commentMessage) {
        if(commentMessage.getFrom() != null){
            CommentHistory history = commentHistoryDao.findById(commentMessage.getFrom().getId()).orElse(null);
            history.getHistory().add(commentMessage);
        }
        return commentMessageDao.save(commentMessage);
    }

    @Override
    public Page<CommentMessage> getCommentMessages(String title, Pageable pageable) {
        return commentMessageDao.getCommentMessages(title,pageable);
    }

}