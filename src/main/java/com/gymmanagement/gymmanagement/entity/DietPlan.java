package com.gymmanagement.gymmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diet_plan")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DietPlan {
    @Id
    private String planId;
    private String dpName;
    private String dietInfo;
    private int dpFee;
    private int bmi;
}
