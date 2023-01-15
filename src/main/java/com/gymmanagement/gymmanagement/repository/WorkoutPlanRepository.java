package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.entity.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan,String> {
    @Query(value = "SELECT * FROM wkt_plan WHERE wkt_plan.bmi BETWEEN :bmiL AND :bmiH AND substring(wkt_plan.plan_id,1,3)= 'PRO'  ",nativeQuery = true)
    List<WorkoutPlan> findProByBMI(int bmiH,int bmiL);


    @Query(value = "SELECT * FROM wkt_plan WHERE wkt_plan.bmi BETWEEN :bmiL AND :bmiH AND substring(wkt_plan.plan_id,1,3)= 'STN'  ",nativeQuery = true)
    List<WorkoutPlan> findStnByBMI(int bmiH, int bmiL);
}
