package com.drifting2.projectbackend.service;

import com.drifting2.projectbackend.entity.Announcement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnnouncementService {

    Integer getAnnouncementSize();
    Announcement getAnnouncement(Long id);
    Page<Announcement> getAnnouncements(Integer pageSize, Integer page);
    Announcement save(Announcement announcement);
    Page<Announcement> getAnnouncements(String title, Pageable pageable);



}
