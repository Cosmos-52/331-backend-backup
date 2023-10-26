package com.drifting2.projectbackend.controller;

import com.drifting2.projectbackend.entity.Roles;
import com.drifting2.projectbackend.service.RolesService;
import com.drifting2.projectbackend.util.LabMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RolesController {

    final RolesService rolesService;

    List<Roles> rolesList;

    @GetMapping("Roles")
    public ResponseEntity<?> getStudentLists(@RequestParam(value ="_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page,
                                             @RequestParam(value = "title", required = false) String title) {

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Roles> pageOutput;
        if (title == null) {
            pageOutput = rolesService.getRoles(perPage,page);
        }else{
            pageOutput = rolesService.getRoles(title, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getRoleDTO(pageOutput.getContent()),responseHeader, HttpStatus.OK);

    }





}
