package me.tyrion.glidedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import me.tyrion.glidedemo.ImageUtils;
import me.tyrion.glidedemo.R;

/**
 * Created by taomaogan on 2016/12/18.
 */

public class ResizeActivity extends AppCompatActivity {
    private ImageView mResizeIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resize);
        mResizeIv = (ImageView) findViewById(R.id.resize_iv);
        resize(ImageUtils.sImages[7]);
    }

    private void resize(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .override(200, 300)
                .centerCrop()
                .into(mResizeIv);
//        Glide.with(this)
//                .load(urlStr)
//                .override(200, 300)
//                .fitCenter()
//                .into(mResizeIv);
    }
}
