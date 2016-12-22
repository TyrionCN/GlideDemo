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

public class ThumbnailActivity extends AppCompatActivity {
    private ImageView mThumbnailIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thumbnail);
        mThumbnailIv = (ImageView) findViewById(R.id.thumbnail_iv);
        thumbnail(ImageUtils.sImages[3]);
    }

    private void thumbnail(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .thumbnail(0.1f)
                .into(mThumbnailIv);
    }
}
