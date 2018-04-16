package com.eigendaksh.simpledagger.data;

import android.content.SharedPreferences;

import com.eigendaksh.simpledagger.data.Member;

import java.util.ArrayList;

/**
 * Created by Ashutosh Purushottam on 16/04/18.
 * Eigendaksh Development Studio
 */

public class MemberDataManager {

    private static final String COUNT_KEY = "count_key";

    private String memberStatus;
    private ArrayList<Member> members = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    private int currentCount;


    public MemberDataManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        populateData();
    }

    public MemberDataManager(SharedPreferences sharedPreferences, NetworkManager networkManager) {
        this.sharedPreferences = sharedPreferences;
        populateData();
    }


    public String checkMemberStatus(String userInput) {

        memberStatus = "Access Denied";

        for (Member m : members) {
            if ((m.getMemberId().equals(userInput))) {
                updateAccessCount();
                memberStatus = "Access Granted and Access Count is: " + getCurrentCount();
            }
        }
        return memberStatus;
    }


    private void updateAccessCount() {
        currentCount = sharedPreferences.getInt(COUNT_KEY, 0) + 1;
        sharedPreferences.edit().putInt(COUNT_KEY, currentCount).apply();

    }


    private void populateData() {
        members.add(new Member("122", "Sonu", "sonu@gmail.com"));
        members.add(new Member("128", "Sheetal", "sheetal@gmail.com"));
        members.add(new Member("672", "Ritik", "ritik@gmail.com"));
        members.add(new Member("232", "Rupi", "rupi@gmail.com"));
        members.add(new Member("119", "Ashi", "ashi@gmail.com"));
        members.add(new Member("601", "Rinku", "rinku@gmail.com"));
    }

    public int getCurrentCount() {
        return currentCount;
    }
}
