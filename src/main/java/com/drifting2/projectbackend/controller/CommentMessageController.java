package com.drifting2.projectbackend.controller;

import com.drifting2.projectbackend.entity.CommentMessage;
import com.drifting2.projectbackend.util.LabMapper;
import lombok.RequiredArgsConstructor;
import com.drifting2.projectbackend.service.CommentMessageService;

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
public class CommentMessageController {
    List<CommentMessage> commentMessageList;
    final CommentMessageService commentMessageService;
    @GetMapping("comments")
    public ResponseEntity<?> getCommentMessageLists(@RequestParam(value ="_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "title", required = false) String title) {
                                                
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<CommentMessage> pageOutput;
        if (title == null) {
            pageOutput = commentMessageService.getCommentMessages(perPage,page);
        }else{
            pageOutput = commentMessageService.getCommentMessages(title,PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getCommentMessageDTO(pageOutput.getContent()),responseHeader,HttpStatus.OK);

    }

    @GetMapping("comments/{id}")
    public ResponseEntity<?> getCommentMessage(@PathVariable("id") Long id) {
        CommentMessage output = commentMessageService.getCommentMessage(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getCommentMessageDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/comments")
    public ResponseEntity<?> addCommentMessage(@RequestBody CommentMessage CommentMessage){
        CommentMessage output = commentMessageService.save(CommentMessage);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentMessageDTO(output));
    }

}
