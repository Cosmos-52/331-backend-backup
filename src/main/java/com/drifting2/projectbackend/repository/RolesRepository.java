package com.drifting2.projectbackend.repository;

import com.drifting2.projectbackend.entity.Roles;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolesRepository extends JpaRepository<Roles,Long> {

    List<Roles> findAll();

    Roles findByType(String type);

    Page<Roles> findByTypeContaining(String type, Pageable pageRequest);

}
