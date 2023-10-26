package com.drifting2.projectbackend.dao;


import com.drifting2.projectbackend.entity.Roles;
import com.drifting2.projectbackend.repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class RolesDaoDBImpl implements RolesDao {

    final RolesRepository rolesRepository;

    @Override
    public Integer getRoleSize() {
        return Math.toIntExact(rolesRepository.count());
    }

    @Override
    public Page<Roles> getRoles(Integer pageSize, Integer page) {
        return rolesRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Roles getRole(Long id) {
        return rolesRepository.findById(id).orElse(null);
    }

    @Override
    public Roles getRole(String type) {
        return rolesRepository.findByType(type);
    }

    @Override
    public Page<Roles> getRoles(String title, Pageable page) {
        return rolesRepository.findByTypeContaining(title,page);
    }




}
