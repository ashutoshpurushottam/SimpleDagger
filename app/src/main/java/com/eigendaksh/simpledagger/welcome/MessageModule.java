package com.eigendaksh.simpledagger.welcome;

import com.eigendaksh.simpledagger.data.MessageGenerator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ashutosh Purushottam on 16/04/18.
 * Eigendaksh Development Studio
 */

@Module
public class MessageModule {

    @WelcomeActivityScope
    @Provides
    public MessageGenerator provideMessageGenerator() {
        return new MessageGenerator();
    }
}
