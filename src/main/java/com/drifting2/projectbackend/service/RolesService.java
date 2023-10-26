package com.drifting2.projectbackend.service;

import com.drifting2.projectbackend.entity.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RolesService {
    Integer getRoleSize();
    Roles getRole(Long id);
    Page<Roles> getRoles(Integer pageSize, Integer page);
    Page<Roles> getRoles(String type, Pageable pageable);
}
