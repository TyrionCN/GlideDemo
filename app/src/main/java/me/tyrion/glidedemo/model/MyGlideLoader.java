package me.tyrion.glidedemo.model;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;

/**
 * Created by taomaogan on 2016/12/21.
 */

public class MyGlideLoader extends BaseGlideUrlLoader<Integer> {

    public MyGlideLoader(Context context) {
        super(context);
    }

    @Override
    protected String getUrl(Integer model, int width, int height) {
        Log.e("MyGlideLoader$getUrl", Thread.currentThread().toString());
        return null;
    }
}
