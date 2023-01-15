package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.entity.DietPlan;
import com.gymmanagement.gymmanagement.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
    @Query(value = "SELECT * FROM member WHERE email=:emailId",nativeQuery = true)
    Member findByEmailId(String emailId);

}
