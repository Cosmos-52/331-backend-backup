package com.drifting2.projectbackend.dao;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import com.drifting2.projectbackend.entity.CommentMessage;
import com.drifting2.projectbackend.repository.CommentMessageRepository;


@Repository
@RequiredArgsConstructor
@Profile("db")
public class CommentMessageDaoDBImpl implements CommentMessageDao{
    final CommentMessageRepository commentMsgRepository;
    @Override
    public Integer getCommentMessageSize() {
        return Math.toIntExact(commentMsgRepository.count());
    }

    @Override
    public Page<CommentMessage> getCommentMessages(Integer pageSize, Integer page) {
        return commentMsgRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public CommentMessage getCommentMessage(Long id) {
        return commentMsgRepository.findById(id).orElse(null);
    }

    @Override
    public CommentMessage save(CommentMessage student) {
        return commentMsgRepository.save(student);
    }

    @Override
    public Page<CommentMessage> getCommentMessages(String title, Pageable page) {
        return commentMsgRepository.findAll(page);
    }

}
