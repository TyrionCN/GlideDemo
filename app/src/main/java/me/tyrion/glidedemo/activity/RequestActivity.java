package me.tyrion.glidedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

import me.tyrion.glidedemo.ImageUtils;
import me.tyrion.glidedemo.R;

/**
 * Created by taomaogan on 2016/12/18.
 * 图片请求级别，仅仅是说请求先后顺序，但是请求后加载图片没有先后顺序
 * 但是高请求级别的卡住了怎么办？
 */

public class RequestActivity extends AppCompatActivity {
    private ImageView mImmedateIv;
    private ImageView mHighIv;
    private ImageView mNormalIv;
    private ImageView mLowIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        initView();
        loadWithHighPriority(ImageUtils.sImages[0]);
        loadWithImmedatePriority(ImageUtils.sImages[0]);
        loadWithLowPriority(ImageUtils.sImages[0]);
        loadWithNormalPriority(ImageUtils.sImages[0]);
    }

    private void initView() {
        mImmedateIv = (ImageView) findViewById(R.id.immedate_iv);
        mHighIv = (ImageView) findViewById(R.id.high_iv);
        mNormalIv = (ImageView) findViewById(R.id.normal_iv);
        mLowIv = (ImageView) findViewById(R.id.low_iv);
    }

    private void loadWithLowPriority(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .priority(Priority.LOW)
                .into(mLowIv);
    }

    private void loadWithNormalPriority(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .priority(Priority.NORMAL)
                .into(mNormalIv);
    }

    private void loadWithHighPriority(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .priority(Priority.HIGH)
                .into(mHighIv);
    }

    private void loadWithImmedatePriority(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .priority(Priority.IMMEDIATE)
                .into(mImmedateIv);
    }
}
