package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.entity.Member;
import com.gymmanagement.gymmanagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl {
    @Autowired
    private MemberRepository memberRepository;
    public List<Member> getAll() {
        List<Member> memberList = memberRepository.findAll();
        return memberList;
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
