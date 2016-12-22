package me.tyrion.glidedemo.model;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by taomaogan on 2016/12/22.
 */

public class OptionsGlideModule implements GlideModule {

    private static final int BITMAP_SIZE = 2 * 1024 * 1024;
    private static final int MEMORY_CACHE = 4 * 1024 * 1024;
    private static final int DISK_CACHE = 16 * 1024 * 1024;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setBitmapPool(new LruBitmapPool(BITMAP_SIZE))   //bitmap缓存池
                .setDecodeFormat(DecodeFormat.PREFER_ARGB_8888) //设置图片格式
                .setMemoryCache(new LruResourceCache(MEMORY_CACHE)) //内存缓存池
                .setDiskCache(new InternalCacheDiskCacheFactory(context, DISK_CACHE));    //磁盘缓存池
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
