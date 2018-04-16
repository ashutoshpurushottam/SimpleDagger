package com.eigendaksh.simpledagger.di;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ashutosh Purushottam on 16/04/18.
 * Eigendaksh Development Studio
 */

@Module
public class DateAndTimeModule {

    @Singleton
    @Provides
    public Calendar provideCalendar() {
        return Calendar.getInstance();
    }

    @Singleton
    @Named("dd-MMM-yy")
    @Provides
    public String provideOnlyDate(Calendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YY");
        return simpleDateFormat.format(calendar.getTime());
    }

    @Singleton
    @Named("dd-MM-YY HH:mm:ss")
    @Provides
    public String provideDateAndTime(Calendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YY HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
    }


}
