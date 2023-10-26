package com.drifting2.projectbackend.dao;

import com.drifting2.projectbackend.entity.Announcement;
import com.drifting2.projectbackend.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnnouncementDao {

    Integer getAnnouncementSize();
    Announcement getAnnouncement(Long id);
    Page<Announcement> getAnnouncements(Integer pageSize, Integer page);

    Announcement save(Announcement announcement);
    Page<Announcement> getAnnouncements(String title, Pageable pageable);

}
