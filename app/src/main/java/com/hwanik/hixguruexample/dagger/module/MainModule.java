package com.hwanik.hixguruexample.dagger.module;

import com.hwanik.hixguruexample.adapter.CustomAdapter;
import com.hwanik.hixguruexample.presenter.MainPresenter;
import com.hwanik.hixguruexample.presenter.MainPresenterImpl;
import com.hwanik.hixguruexample.view.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kotlin.internal.LowPriorityInOverloadResolution;

/**
 * Created by hwanik on 2016. 12. 26..
 */

@Module
public class MainModule {

    private MainPresenter.View view;

    public MainModule(MainPresenter.View view) {
        this.view = view;
    }

    @Provides
    MainPresenter provideMainPresenter(MainPresenterImpl mainPresenter) {
        return mainPresenter;
    }

    @Provides
    MainPresenter.View provideView(){
        return view;
    }
}
