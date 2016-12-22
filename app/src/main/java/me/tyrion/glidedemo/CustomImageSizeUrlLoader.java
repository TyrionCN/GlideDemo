package me.tyrion.glidedemo;

import android.content.Context;

import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;

import me.tyrion.glidedemo.model.ImageSizeModel;

/**
 * Created by taomaogan on 2016/12/20.
 */

public class CustomImageSizeUrlLoader extends BaseGlideUrlLoader<ImageSizeModel> {

    public CustomImageSizeUrlLoader(Context context) {
        super(context);
    }

    @Override
    protected String getUrl(ImageSizeModel model, int width, int height) {
        return model.requestCustomSizeUrl(width, height);
    }
}
