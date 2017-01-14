package com.hwanik.hixguruexample.view;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.graphics.BitmapCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hwanik.hixguruexample.R;
import com.hwanik.hixguruexample.adapter.CustomAdapter;
import com.hwanik.hixguruexample.dagger.component.DaggerAppComponent;
import com.hwanik.hixguruexample.dagger.module.AppModule;
import com.hwanik.hixguruexample.dagger.module.MainModule;
import com.hwanik.hixguruexample.presenter.MainPresenter;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import org.w3c.dom.Text;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    @Inject Application mApplication;
    @Inject MainPresenter mainPresenter;

    @BindView(R.id.btn_start_kotlin) Button btnStartKotlinActivity;
    @BindView(R.id.viewpager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

        viewPager.setAdapter(new CustomAdapter(MainActivity.this));
    }
}

