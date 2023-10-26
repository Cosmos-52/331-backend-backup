package com.drifting2.projectbackend.dao;

import com.drifting2.projectbackend.entity.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RolesDao {
    Integer getRoleSize();
    Page<Roles> getRoles(Integer pageSize, Integer page);
    Roles getRole(Long id);
    Roles getRole(String type);
    Page<Roles> getRoles(String type, Pageable page);
}
