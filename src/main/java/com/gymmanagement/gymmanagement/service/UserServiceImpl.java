package com.gymmanagement.gymmanagement.service;

import com.gymmanagement.gymmanagement.entity.Member;
import com.gymmanagement.gymmanagement.entity.User;
import com.gymmanagement.gymmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MemberServiceImpl memberService;

    public String loginUser(String emailId, String password) {
        User user = userRepository.findByEmailId(emailId);
        if(user!=null && user.getPassword().equals(password)){
            return user.getEmailId();
        } else {
            return "Failed";
        }
    }

    public String registerUser(User user,Member member) {
        User user1 = userRepository.findByEmailId(user.getEmailId());
        if(user1!=null){
            return "User Already Exists";
        } else {
//            Member member = new Member();
//            member.setEmail(user.getEmailId());
            memberService.saveMember(member);
            userRepository.save(user);
            return "User Created Succesfully";
        }
    }
}
