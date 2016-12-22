package me.tyrion.glidedemo.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;

import me.tyrion.glidedemo.ImageUtils;
import me.tyrion.glidedemo.R;
import me.tyrion.glidedemo.widget.CircleLoading;

/**
 * Created by taomaogan on 2016/12/18.
 * 尽管Glide有transformation功能，但是我们还是有些自定义控件没法兼顾，glide给我们提供了另一种选择
 */

public class TargetAcitivity extends AppCompatActivity {
    private CircleLoading mCustomCl;
    private ImageView mSimpleTargetIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        mCustomCl = (CircleLoading) findViewById(R.id.custom_cl);
        mSimpleTargetIv = (ImageView) findViewById(R.id.simple_target_iv);
        addCustom(ImageUtils.sImages[8]);
        addSimple(ImageUtils.sImages[6]);
    }

    private void addCustom(String urlStr) {
        ViewTarget viewTarget = new ViewTarget<CircleLoading, GlideDrawable>(mCustomCl) {

            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                mCustomCl.setBackground(resource.getCurrent());
            }
        };
        Glide.with(this)
                .load(urlStr)
                .into(viewTarget);
    }

    private void addSimple(String urlStr) {
        SimpleTarget simpleTarget = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                mSimpleTargetIv.setImageBitmap(resource);
            }
        };
        Glide.with(this)
                .load(urlStr)
                .asBitmap()
                .into(simpleTarget);
    }
}
