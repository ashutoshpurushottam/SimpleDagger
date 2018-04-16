package com.eigendaksh.simpledagger.welcome;

import com.eigendaksh.simpledagger.data.MessageGenerator;
import com.eigendaksh.simpledagger.di.MemberAppComponent;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by Ashutosh Purushottam on 16/04/18.
 * Eigendaksh Development Studio
 */

@WelcomeActivityScope
@Subcomponent(modules = MessageModule.class)
public interface WelcomeActivityComponent {
    void inject(WelcomeActivity welcomeActivity);
    MessageGenerator myMessageGenerator();
}
