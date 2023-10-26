package com.drifting2.projectbackend.service;


import com.drifting2.projectbackend.dao.RolesDao;
import com.drifting2.projectbackend.entity.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {
    final RolesDao rolesDao;

    @Override
    public Integer getRoleSize() {
        return rolesDao.getRoleSize();
    }

    public Roles getRole(Long id) {
        return rolesDao.getRole(id);
    }

    @Override
    public Page<Roles> getRoles(Integer pageSize, Integer page) {
        return rolesDao.getRoles(pageSize, page);
    }

    @Override
    public Page<Roles> getRoles(String type, Pageable pageable) {
        return rolesDao.getRoles(type,pageable);
    }

}
