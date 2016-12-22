package me.tyrion.glidedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import me.tyrion.glidedemo.R;

/**
 * Created by taomaogan on 2016/12/18.
 */

public class ModelActivity extends AppCompatActivity {
    private ImageView mUrlFetcherIv;
    private ImageView mCacheIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        initView();
    }

    private void initView() {
        mUrlFetcherIv = (ImageView) findViewById(R.id.url_fetcher_iv);
        mCacheIv = (ImageView) findViewById(R.id.cache_iv);
    }

    private void useUrlFetcher() {

    }
}
