package com.hwanik.hixguruexample.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.hwanik.hixguruexample.R;
import com.hwanik.hixguruexample.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hwanik on 2017. 1. 9..
 */

public class CustomAdapter extends PagerAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int[] fanArtImages = {
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3
    };

    @BindView(R.id.fan_art) ImageView fanArt;
    @BindView(R.id.content) EditText content;

    public CustomAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return fanArtImages.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewGroup view = null;
        view = (ViewGroup) mLayoutInflater.inflate(R.layout.pager_layout, null);
        ButterKnife.bind(this, view);

        container.addView(view);
        Bitmap img = Util.decodeSampledBitmapFromResource(mContext.getResources(), fanArtImages[position], 200, 400);
        fanArt.setImageBitmap(img);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}



