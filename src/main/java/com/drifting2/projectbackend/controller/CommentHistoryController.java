package com.drifting2.projectbackend.controller;

import com.drifting2.projectbackend.entity.CommentHistory;
import com.drifting2.projectbackend.util.LabMapper;
import lombok.RequiredArgsConstructor;
import com.drifting2.projectbackend.service.CommentHistoryService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentHistoryController {
    List<CommentHistory> commentHistoryList;
    final CommentHistoryService commentHistoryService;
    @GetMapping("history")
    public ResponseEntity<?> getCommentHistoryLists(@RequestParam(value ="_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "advisorId", required = false) Integer advisorId,
                                            @RequestParam(value = "adviseeId", required = false) Integer adviseeId) {
                                                
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<CommentHistory> pageOutput;
        if (advisorId == null || adviseeId == null) {
            pageOutput = commentHistoryService.getCommentHistory(perPage,page);
        }else{
            pageOutput = commentHistoryService.getCommentHistory(advisorId, adviseeId, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getCommentHistoryDTO(pageOutput.getContent()),responseHeader,HttpStatus.OK);

    }

    @GetMapping("history/{id}")
    public ResponseEntity<?> getCommentHistory(@PathVariable("id") Long id) {
        CommentHistory output = commentHistoryService.getCommentHistory(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getCommentHistoryDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/history")
    public ResponseEntity<?> addCommentHistory(@RequestBody CommentHistory CommentHistory){
        CommentHistory output = commentHistoryService.save(CommentHistory);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentHistoryDTO(output));
    }

}
