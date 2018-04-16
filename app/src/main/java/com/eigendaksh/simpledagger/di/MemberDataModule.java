package com.eigendaksh.simpledagger.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.eigendaksh.simpledagger.data.MemberDataManager;
import com.eigendaksh.simpledagger.data.NetworkManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ashutosh Purushottam on 16/04/18.
 * Eigendaksh Development Studio
 */

@Module
public class MemberDataModule {

    private Context context;

    public MemberDataModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    NetworkManager provideNetworkManager() {
        return new NetworkManager();
    }

    @Singleton
    @Provides
    @Named("local")
    MemberDataManager provideLocalMemberDataManager(SharedPreferences sharedPreferences) {
        return new MemberDataManager(sharedPreferences);
    }

    @Singleton
    @Provides
    @Named("online")
    MemberDataManager provideOnlineMemberDataManager(SharedPreferences sharedPreferences, NetworkManager networkManager) {
        return new MemberDataManager(sharedPreferences, networkManager);
    }


}
