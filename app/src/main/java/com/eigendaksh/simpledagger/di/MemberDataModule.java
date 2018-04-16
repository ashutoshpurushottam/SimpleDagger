package com.eigendaksh.simpledagger.di;

import com.eigendaksh.simpledagger.data.MemberDataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ashutosh Purushottam on 16/04/18.
 * Eigendaksh Development Studio
 */

@Module
public class MemberDataModule {

    @Singleton
    @Provides
    MemberDataManager provideMemberDataManager() {
        return new MemberDataManager();
    }
}
