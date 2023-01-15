package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.entity.*;
import com.gymmanagement.gymmanagement.repository.DietPlanRepository;
import com.gymmanagement.gymmanagement.repository.MemberRepository;
import com.gymmanagement.gymmanagement.repository.WorkoutPlanRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DietPlanRepository dietPlanRepository;

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    public List<Member> getAll() {
        List<Member> memberList = memberRepository.findAll();
        return memberList;
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public Member getAMember(int id) {
        return memberRepository.findById(id).get();
    }

    public Member addMembership(int memberId, Membership membership) {
        Member currentMember = memberRepository.findById(memberId).get();
        currentMember.addMembership(membership);
        return memberRepository.save(currentMember);
    }

    public Member getMemberByEmailId(String emailId) {
        return memberRepository.findByEmailId(emailId);
    }

    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Plan> getProPlanByBmi(int bmi) {
        List<DietPlan> dietPlan = dietPlanRepository.findProByBMI(bmi+2,bmi-2);
        List<WorkoutPlan> workoutPlan = workoutPlanRepository.findProByBMI(bmi+2,bmi-2);
        List<Plan> plans = new ArrayList<>();
        int cnt=0;
        for(DietPlan dietPlan1 : dietPlan){
            plans.add(Plan.builder().planId(dietPlan1.getPlanId()).bmi(bmi).diet(dietPlan1).wkt(workoutPlan.get(cnt++)).build());
        }
        return plans;
//        return Plan.builder().planId(dietPlan.getPlanId()).diet(dietPlan).bmi(bmi).build();
    }

    public List<Plan> getStnPlanByBmi(int bmi) {
        List<WorkoutPlan> workoutPlan = workoutPlanRepository.findStnByBMI(bmi+2,bmi-2);
        List<Plan> plans = new ArrayList<>();
        for(WorkoutPlan workoutPlan1 : workoutPlan){
            plans.add(Plan.builder().planId(workoutPlan1.getPlanId()).wkt(workoutPlan1).bmi(bmi).build());
        }
        return  plans;

    }
}
