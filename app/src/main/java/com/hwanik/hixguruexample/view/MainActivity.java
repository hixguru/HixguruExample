package com.hwanik.hixguruexample.view;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hwanik.hixguruexample.R;
import com.hwanik.hixguruexample.dagger.component.DaggerAppComponent;
import com.hwanik.hixguruexample.dagger.module.AppModule;
import com.hwanik.hixguruexample.dagger.module.MainModule;
import com.hwanik.hixguruexample.presenter.MainPresenter;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import org.w3c.dom.Text;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    @Inject Application mApplication;
    @Inject MainPresenter mainPresenter;

    private EditText userEmail;
    private EditText userPassword;
    private TextView userEmailWarning;
    private Button btnStartKotlinActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

        userEmail = (EditText) findViewById(R.id.user_email);
        userPassword = (EditText) findViewById(R.id.user_password);
        userEmailWarning = (TextView) findViewById(R.id.user_email_warning);
        btnStartKotlinActivity = (Button) findViewById(R.id.btn_start_kotlin);

        Subscription editTextSub =
                RxTextView.textChanges(userEmail)
                        .subscribe(new Action1<CharSequence>() {
                            @Override
                            public void call(CharSequence charSequence) {
                                mainPresenter.validateEmail(String.valueOf(charSequence));
                            }
                        });

        RxView.clicks(btnStartKotlinActivity)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        mainPresenter.login(userEmail.getText().toString(), userPassword.getText().toString());
                    }
                });
    }

    @Override
    public void showEmailWarning() {
        userEmailWarning.setText("정확한 이메일 형식이 아닙니다.");
    }

    @Override
    public void showEmailCorrect() {
        userEmailWarning.setText("사용할 수 있는 이메일 형식입니다.");
    }
}
