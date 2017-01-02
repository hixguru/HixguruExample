package com.hwanik.hixguruexample.presenter;

/**
 * Created by hwanik on 2016. 12. 26..
 */

public interface MainPresenter {

    void login(String userEmail, String userPassword);

    void validateEmail(String email);

    interface View {
        void showEmailWarning();
        void showEmailCorrect();
    }
}
