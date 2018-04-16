package com.eigendaksh.simpledagger.welcome;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Ashutosh Purushottam on 16/04/18.
 * Eigendaksh Development Studio
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface WelcomeActivityScope {
}
