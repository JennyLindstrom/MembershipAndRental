package com.lindström.entity;

import java.util.HashMap;
import java.util.Map;


public class MemberRegistry {
    private static final Map<Integer, Member> members = new HashMap<>();


    public static void addMember(Member member) {
        members.put(member.getId(), member);
    }

    public Member findMemberById(int id) {
        return members.get(id);
    }

    public Map listMembers() {
        return members;
    }
}
