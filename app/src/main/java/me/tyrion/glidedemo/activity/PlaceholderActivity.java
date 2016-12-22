package me.tyrion.glidedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.animation.DrawableCrossFadeFactory;

import me.tyrion.glidedemo.ImageUtils;
import me.tyrion.glidedemo.R;

/**
 * Created by taomaogan on 2016/12/18.
 */

public class PlaceholderActivity extends AppCompatActivity {
    private ImageView mPlaceholderIv;
    private ImageView mErrorPlaceHolderIv;
    private ImageView mCrossFadeIv;
    private ImageView mNotAnimatorIv;
    private ImageView mThumbnailIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);
        initView();
        String urlStr = ImageUtils.sImages[4];
        addPlaceHolder(urlStr);
        addErrorPlaceholder(urlStr);
        crossFade(urlStr);
        notAnimator(urlStr);
        addThumbnails(urlStr);
    }

    private void initView() {
        mPlaceholderIv = (ImageView) findViewById(R.id.placeholder_iv);
        mErrorPlaceHolderIv = (ImageView) findViewById(R.id.error_placeholder_iv);
        mCrossFadeIv = (ImageView) findViewById(R.id.crossfade_iv);
        mNotAnimatorIv = (ImageView) findViewById(R.id.notanimate_iv);
        mThumbnailIv = (ImageView) findViewById(R.id.thumbnail_iv);
    }

    private void addPlaceHolder(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .placeholder(R.drawable.book2)
                .into(mPlaceholderIv);
    }

    private void addErrorPlaceholder(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .error(R.drawable.book1)
                .into(mErrorPlaceHolderIv);
    }

    private void crossFade(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .placeholder(R.drawable.book2)
                .crossFade()
                .into(mCrossFadeIv);
    }

    private void notAnimator(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .dontAnimate()
                .into(mNotAnimatorIv);
    }

    private void addThumbnails(String urlStr) {
        DrawableRequestBuilder builder =
                Glide.with(this).load(ImageUtils.sImages[7]);

        Glide.with(this)
                .load(urlStr)
                .thumbnail(builder)
                .into(mThumbnailIv);
    }
}
