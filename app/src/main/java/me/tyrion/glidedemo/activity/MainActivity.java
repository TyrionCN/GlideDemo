package me.tyrion.glidedemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.tyrion.glidedemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.simple_tv).setOnClickListener(this);
        findViewById(R.id.animtor_tv).setOnClickListener(this);
        findViewById(R.id.model_tv).setOnClickListener(this);
        findViewById(R.id.placeholde_tv).setOnClickListener(this);
        findViewById(R.id.request_tv).setOnClickListener(this);
        findViewById(R.id.resize_tv).setOnClickListener(this);
        findViewById(R.id.target_tv).setOnClickListener(this);
        findViewById(R.id.thumbnail_tv).setOnClickListener(this);
        findViewById(R.id.transformation_tv).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simple_tv:
                startActivity(new Intent(this, SimpleActivity.class));
                break;

            case R.id.animtor_tv:
                startActivity(new Intent(this, AnimatorActivity.class));
                break;

            case R.id.cache_tv:
                startActivity(new Intent(this, CacheActivity.class));
                break;

            case R.id.model_tv:
                startActivity(new Intent(this, ModelActivity.class));
                break;

            case R.id.placeholde_tv:
                startActivity(new Intent(this, PlaceholderActivity.class));
                break;

            case R.id.request_tv:
                startActivity(new Intent(this, RequestActivity.class));
                break;

            case R.id.resize_tv:
                startActivity(new Intent(this, ResizeActivity.class));
                break;

            case R.id.target_tv:
                startActivity(new Intent(this, TargetAcitivity.class));
                break;

            case R.id.thumbnail_tv:
                startActivity(new Intent(this, ThumbnailActivity.class));
                break;

            case R.id.transformation_tv:
                startActivity(new Intent(this, TransformationActivity.class));
                break;
        }
    }
}
