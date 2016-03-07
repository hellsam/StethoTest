package com.hellsam.stethotest;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

/**
 * Created by binshenchen on 16/3/4.
 */
public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        Stetho.initializeWithDefaults(this);
    }

    public static Context getContext(){
        return mContext;
    }
}
