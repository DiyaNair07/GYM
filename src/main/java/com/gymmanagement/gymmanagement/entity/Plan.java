package com.gymmanagement.gymmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Plan {

    private String planId;
    private WorkoutPlan wkt;
    private DietPlan diet;
    private int bmi;

}
