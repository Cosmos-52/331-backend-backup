package com.drifting2.projectbackend.repository;

import com.drifting2.projectbackend.entity.CommentMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentMessageRepository extends JpaRepository<CommentMessage,Long> {
    List<CommentMessage> findAll();
}