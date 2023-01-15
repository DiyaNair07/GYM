package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.entity.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietPlanRepository extends JpaRepository<DietPlan,String> {
    @Query(value = "Select * FROM diet_plan WHERE bmi BETWEEN :bmiL AND :bmiH AND substring(diet_plan.plan_id,1,3)= 'PRO'  ",nativeQuery = true)
    List<DietPlan> findProByBMI(int bmiH,int bmiL);
}
