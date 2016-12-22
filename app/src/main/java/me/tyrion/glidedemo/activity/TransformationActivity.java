package me.tyrion.glidedemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import me.tyrion.glidedemo.ImageUtils;
import me.tyrion.glidedemo.R;
import me.tyrion.glidedemo.transformation.ColorFilterTransformation;
import me.tyrion.glidedemo.transformation.CropCircleTransformation;
import me.tyrion.glidedemo.transformation.RoundedCornersTransformation;

/**
 * Created by taomaogan on 2016/12/18.
 */

public class TransformationActivity extends AppCompatActivity {
    private ImageView mTransformationIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformation);
        mTransformationIv = (ImageView) findViewById(R.id.transformation_iv);
        addTransformation(ImageUtils.sImages[5]);
    }

    /**
     * transfromation不能叠加，只能一次性做完，例如下面，只有最后一个起作用
     * @param urlStr
     */
    private void addTransformation(String urlStr) {
        Glide.with(this)
                .load(urlStr)
                .bitmapTransform(new CropCircleTransformation(this))
                .bitmapTransform(new RoundedCornersTransformation(this, 30, 10))
                .bitmapTransform(new ColorFilterTransformation(this, Color.argb(80, 255, 0, 0)))
                .into(mTransformationIv);
    }
}
