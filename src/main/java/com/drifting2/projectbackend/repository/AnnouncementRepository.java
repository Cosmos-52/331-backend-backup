package com.drifting2.projectbackend.repository;

import com.drifting2.projectbackend.entity.Announcement;
import com.drifting2.projectbackend.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {

    List<Announcement> findAll();

    Page<Announcement> findByTitleContainingOrContentIgnoreCaseContainingOrDateIgnoreCaseContaining(String title, String content, String date, Pageable pageRequest);

    Announcement findByTitle(String title);

    Announcement findByContent(String content);

    Announcement findByDate(String date);




}
