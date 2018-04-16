package com.eigendaksh.simpledagger.di;

import com.eigendaksh.simpledagger.home.MainActivity;
import com.eigendaksh.simpledagger.welcome.MessageModule;
import com.eigendaksh.simpledagger.welcome.WelcomeActivity;
import com.eigendaksh.simpledagger.welcome.WelcomeActivityComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ashutosh Purushottam on 16/04/18.
 * Eigendaksh Development Studio
 */

@Singleton
@Component(modules = {
        MemberDataModule.class,
        DateAndTimeModule.class,
})
public interface MemberAppComponent {
    void inject(MainActivity mainActivity);
    WelcomeActivityComponent newWelcomeActivityComponent(MessageModule messageModule);
}
