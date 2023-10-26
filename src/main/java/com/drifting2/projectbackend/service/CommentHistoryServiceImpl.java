package com.drifting2.projectbackend.service;

import com.drifting2.projectbackend.dao.CommentHistoryDao;
import com.drifting2.projectbackend.entity.CommentHistory;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class CommentHistoryServiceImpl implements CommentHistoryService{
    final CommentHistoryDao commentHistoryDao;
    @Override
    public Integer getCommentHistorySize() {
        return commentHistoryDao.getCommentHistorySize();
    }

    @Override
    public Page<CommentHistory> getCommentHistory(Integer pageSize, Integer page) {
        return commentHistoryDao.getCommentHistory(pageSize, page);
    }

    @Override
    public CommentHistory getCommentHistory(Long id) {
        return commentHistoryDao.getCommentHistory(id);
    }

    @Override
    @Transactional
    public CommentHistory save(CommentHistory student) {
        return commentHistoryDao.save(student);
    }

    @Override
    public Page<CommentHistory> getCommentHistory(Integer advisorId, Integer adviseeId, Pageable pageable) {
        return commentHistoryDao.getCommentHistory(advisorId, adviseeId,pageable);
    }

}