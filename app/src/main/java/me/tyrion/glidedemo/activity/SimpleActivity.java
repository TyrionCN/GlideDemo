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

public class SimpleActivity extends AppCompatActivity {
    private ImageView mSimpleIv;
    private ImageView mSimpleBitmapIv;
    private ImageView mSimpleGifIv;
    private ImageView mSimpleVideoIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        initView();
        String bitmapUrl = ImageUtils.sImages[1];
        String gifUrl = ImageUtils.sImages[ImageUtils.sImages.length - 2];
        String videoUrl = ImageUtils.sImages[ImageUtils.sImages.length - 1];
        loadSimple(bitmapUrl);
        loadSimpleBitmap(bitmapUrl);
        loadSimpleGif(gifUrl);
    }

    private void initView() {
        mSimpleIv = (ImageView) findViewById(R.id.simple_iv);
        mSimpleBitmapIv = (ImageView) findViewById(R.id.simple_bitmap_iv);
        mSimpleGifIv = (ImageView) findViewById(R.id.simple_gif_iv);
        mSimpleVideoIv = (ImageView) findViewById(R.id.simple_video_iv);
    }

    private void loadSimple(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .into(mSimpleIv);
    }

    private void loadSimpleBitmap(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .asBitmap()
                .into(mSimpleBitmapIv);
    }

    private void loadSimpleGif(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .asGif()
                .into(mSimpleGifIv);
    }

    private void loadSimpleVideo(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .into(mSimpleVideoIv);
    }
}
