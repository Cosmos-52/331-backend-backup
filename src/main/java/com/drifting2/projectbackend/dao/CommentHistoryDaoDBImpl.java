package com.drifting2.projectbackend.dao;
import java.util.Optional;

import com.drifting2.projectbackend.entity.CommentHistory;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import com.drifting2.projectbackend.repository.CommentHistoryRepository;


@Repository
@RequiredArgsConstructor
@Profile("db")
public class CommentHistoryDaoDBImpl implements CommentHistoryDao{
    final CommentHistoryRepository commentHistoryRepository;
    @Override
    public Integer getCommentHistorySize() {
        return Math.toIntExact(commentHistoryRepository.count());
    }

    @Override
    public Page<CommentHistory> getCommentHistory(Integer pageSize, Integer page) {
        return commentHistoryRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public CommentHistory getCommentHistory(Long id) {
        return commentHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public CommentHistory save(CommentHistory student) {
        return commentHistoryRepository.save(student);
    }

    @Override
    public Page<CommentHistory> getCommentHistory(Integer advisorId, Integer adviseeId, Pageable page) {
        try{
            return commentHistoryRepository.findByAdvisorIdAndAdviseeId(Long.valueOf(advisorId), Long.valueOf(adviseeId), page);
        } catch(NumberFormatException e){
            return commentHistoryRepository.findAll(page);
        }
    }

    @Override
    public Optional<CommentHistory> findById(Long id){
        return commentHistoryRepository.findById(id);
    }

}
