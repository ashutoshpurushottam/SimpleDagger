package com.eigendaksh.simpledagger.data;

import com.eigendaksh.simpledagger.data.Member;

import java.util.ArrayList;

/**
 * Created by Ashutosh Purushottam on 16/04/18.
 * Eigendaksh Development Studio
 */

public class MemberDataManager {

    private String memberStatus;
    private ArrayList<Member> members = new ArrayList<>();

    public MemberDataManager() {

        populateData();
    }


    public String checkMemberStatus(String userInput) {

        memberStatus = "Access Denied";

        for (Member m : members) {
            if ((m.getMemberId().equals(userInput))) {
                memberStatus = "Access Granted";
            }
        }
        return memberStatus;
    }


    private void populateData() {
        members.add(new Member("122", "Sonu", "sonu@gmail.com"));
        members.add(new Member("128", "Sheetal", "sheetal@gmail.com"));
        members.add(new Member("672", "Ritik", "ritik@gmail.com"));
        members.add(new Member("232", "Rupi", "rupi@gmail.com"));
        members.add(new Member("119", "Ashi", "ashi@gmail.com"));
        members.add(new Member("601", "Rinku", "rinku@gmail.com"));
    }

}
