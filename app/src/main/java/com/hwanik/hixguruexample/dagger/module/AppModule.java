package com.hwanik.hixguruexample.dagger.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hwanik on 2016. 12. 26..
 */

@Module
public class AppModule {
    Application mApplication;


    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return mApplication;
    }
}
