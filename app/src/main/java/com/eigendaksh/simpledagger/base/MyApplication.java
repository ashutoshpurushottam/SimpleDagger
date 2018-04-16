package com.eigendaksh.simpledagger.base;

import android.app.Application;

import com.eigendaksh.simpledagger.di.DaggerMemberAppComponent;
import com.eigendaksh.simpledagger.di.MemberAppComponent;
import com.eigendaksh.simpledagger.di.MemberDataModule;

/**
 * Created by Ashutosh Purushottam on 16/04/18.
 * Eigendaksh Development Studio
 * Handles the responsibility of instantiating dependencies at the start
 */

public class MyApplication extends Application {

    private static MyApplication myApplication;
    private MemberAppComponent memberAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;

        memberAppComponent = DaggerMemberAppComponent.builder()
                .memberDataModule(new MemberDataModule())
                .build();
    }

    public static MyApplication getApp() {
        return myApplication;
    }

    public MemberAppComponent getMemberAppComponent() {
        return memberAppComponent;
    }
}
