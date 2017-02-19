package com.edu.zscdm.androidwidgetsdemo;

import android.app.Application;

import com.arvin.gifloader.cache.DoubleCache;
import com.arvin.gifloader.cache.MemoryCache;
import com.arvin.gifloader.config.GifLoaderConfig;
import com.arvin.gifloader.core.GifLoader;

/**
 * Created by ZSCDM on 2017/2/18.
 * 作者邮箱：2712220318@qq.com
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GifLoaderConfig config = new GifLoaderConfig();
        config.setCache(new DoubleCache(this, new MemoryCache())).
                setThreadCount(5);
        GifLoader.getInstance().init(config);
    }
}
