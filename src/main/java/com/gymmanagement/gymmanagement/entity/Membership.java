package com.gymmanagement.gymmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "membership")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Membership {
    @Id
    @SequenceGenerator(name = "membership_sequence" , sequenceName = "membership_sequence" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "membership_sequence")
    private int membershipId;
    private String planId;
    private Date joinDate;
    private Date endDate;
    private String memPeriod;
    private String dietplanInclusive;

}
