package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.entity.Member;
import com.gymmanagement.gymmanagement.entity.Membership;
import com.gymmanagement.gymmanagement.entity.Plan;
import com.gymmanagement.gymmanagement.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
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

    @PutMapping("/member/update")
    public ResponseEntity<Member> updateMember(@RequestBody Member member){
        return ResponseEntity.ok(memberService.updateMember(member));
    }

    @GetMapping("member/{id}")
    public ResponseEntity<Member> getMember(@PathVariable int id){
        return ResponseEntity.ok(memberService.getAMember(id));
    }

    @GetMapping("/member/email")
    public ResponseEntity<Member> getMemberByEmail(@RequestParam String emailId){
        return ResponseEntity.ok(memberService.getMemberByEmailId(emailId));
    }

    @PutMapping("/{memberId}/membership")
    public ResponseEntity<Member> addMembership(@PathVariable int memberId,@RequestBody Membership membership){
        return ResponseEntity.ok(memberService.addMembership(memberId,membership));
    }

    @GetMapping("/plans/pro/{bmi}")
    public List<Plan> getProPlanByBmi(@PathVariable int bmi){
        return memberService.getProPlanByBmi(bmi);
    }

    @GetMapping("/plans/stn/{bmi}")
    public List<Plan> getPStnPlanByBmi(@PathVariable int bmi){
        return memberService.getStnPlanByBmi(bmi);
    }

}
