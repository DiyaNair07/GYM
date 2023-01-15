package com.gymmanagement.gymmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wkt_plan")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WorkoutPlan {
    @Id
    private String planId;
    private String wktTime;
    private String planType;
    private String plan;
    private int bmi;
}
