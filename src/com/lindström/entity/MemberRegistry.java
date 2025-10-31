package com.lindström.entity;

import java.util.ArrayList;
import java.util.List;


public class MemberRegistry {
    private final List<Member> memberList = new ArrayList<>();


    public MemberRegistry() {
        initializeMembers();
    }


    public void addMember(Member member) {
        memberList.add(member);
    }

    public Member findMemberById(int id) {
        return memberList.get(id);
    }

    public List<Member> listMembers() {
        return memberList;
    }

    private void initializeMembers() {
        Member member1 = new Member("Anna Bengtsson", "Junior", new ArrayList<>());
        Member member2 = new Member("Julia Bengtsson", "Senior", new ArrayList<>());
        Member member3 = new Member("Adam Bengtsson", "Junior", new ArrayList<>());
        Member member4 = new Member("Anders Bengtsson", "Senior", new ArrayList<>());

        addMember(member1);
        addMember(member2);
        addMember(member3);
        addMember(member4);
    }


}






