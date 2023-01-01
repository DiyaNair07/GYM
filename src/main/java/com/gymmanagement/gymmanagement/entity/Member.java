package com.gymmanagement.gymmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Member {
    @Id
    @SequenceGenerator(name = "member_sequence" , sequenceName = "member_sequence" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "member_sequence")
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_member_id",referencedColumnName = "memberId")
    private List<Membership> memberships;

    public void addMembership(Membership membership){
        memberships.add(membership);
    }

}
