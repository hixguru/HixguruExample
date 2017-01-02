package com.hwanik.hixguruexample.presenter;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;

import com.hwanik.hixguruexample.view.KotlinActivity;

import javax.inject.Inject;

/**
 * Created by hwanik on 2016. 12. 26..
 */

public class MainPresenterImpl implements MainPresenter {

    private View view;
    @Inject Application application;

    @Inject
    public MainPresenterImpl(MainPresenter.View view) {
        this.view = view;
    }

    @Override
    public void login(String userEmail, String userPassword) {
        Intent intent = new Intent(application.getApplicationContext(), KotlinActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("email", userEmail);
        intent.putExtra("password", userPassword);
        application.getApplicationContext().startActivity(intent);
    }

    @Override
    public void validateEmail(String email) {
        boolean isRight = !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        if (!isRight) {
            view.showEmailWarning();
        } else {
            view.showEmailCorrect();
        }
    }
}
