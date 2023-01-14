package com.gymmanagement.gymmanagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Instructor {

    @Id
    @SequenceGenerator(name = "instructor_sequence" , sequenceName = "instructor_sequence" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "instructor_sequence")
    private int instructorId;

    private Long instructorContact;

    private String instructorName;

    private String address;
}
