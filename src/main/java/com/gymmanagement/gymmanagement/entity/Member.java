package com.gymmanagement.gymmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "members")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int memberId;
    private String memberName;
    private int age;
    private String email;
    private String contactNo;
    private String address;
    private String gender;
    private double bmi;
    private double height;
    private double weight;

}
