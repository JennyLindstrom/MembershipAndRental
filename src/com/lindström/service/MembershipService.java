package com.lindström.service;

import com.lindström.entity.Member;

public class MembershipService {
    public void upgradeLevel(Member member) {
        if ("Junior".equalsIgnoreCase(member.getLevel())) {
            member.setLevel("Standard");
            System.out.println(member.getName() + " är nu uppgraderad till Standardmedlem!");

        }


    }
}
