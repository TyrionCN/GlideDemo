package me.tyrion.glidedemo.model;

/**
 * Created by taomaogan on 2016/12/20.
 */

public class ImageSizeModel implements CustomImageSizeModel {
    private String mBaseImageUrl;

    public ImageSizeModel(String baseImageUrl) {
        mBaseImageUrl = baseImageUrl;
    }

    @Override
    public String requestCustomSizeUrl(int width, int height) {
        return mBaseImageUrl + "?w=" + "&h=" + height;
    }
}
