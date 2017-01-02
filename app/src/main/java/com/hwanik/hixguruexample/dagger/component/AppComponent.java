package com.hwanik.hixguruexample.dagger.component;

import com.hwanik.hixguruexample.dagger.module.AppModule;
import com.hwanik.hixguruexample.dagger.module.MainModule;
import com.hwanik.hixguruexample.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hwanik on 2016. 12. 26..
 */
@Component(
        modules = {
                AppModule.class,
                MainModule.class
        }
)
@Singleton
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
