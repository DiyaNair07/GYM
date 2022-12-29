package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.entity.Member;
import com.gymmanagement.gymmanagement.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberServiceImpl memberService;

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAll(){
        List<Member> memberList = memberService.getAll();
        return ResponseEntity.ok(memberList);
    }

    @PostMapping("/member")
    public ResponseEntity<Member> createMember(@RequestBody Member member){
        return ResponseEntity.ok(memberService.saveMember(member));
    }
}
