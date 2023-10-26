package com.drifting2.projectbackend.service;

import com.drifting2.projectbackend.dao.AnnouncementDao;
import com.drifting2.projectbackend.entity.Announcement;
import com.drifting2.projectbackend.entity.Student;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService{
    final AnnouncementDao announcementDao;

    @Override
    public Integer getAnnouncementSize() {
        return announcementDao.getAnnouncementSize();
    }

    @Override
    public Announcement getAnnouncement(Long id) {
        return announcementDao.getAnnouncement(id);
    }

    @Override
    public Page<Announcement> getAnnouncements(Integer pageSize, Integer page) {
        return announcementDao.getAnnouncements(pageSize, page);
    }

    @Override
    @Transactional
    public Announcement save(Announcement announcement) {
        return announcementDao.save(announcement);
    }

    @Override
    public Page<Announcement> getAnnouncements(String title, Pageable pageable) {
        return announcementDao.getAnnouncements(title,pageable);
    }



}
