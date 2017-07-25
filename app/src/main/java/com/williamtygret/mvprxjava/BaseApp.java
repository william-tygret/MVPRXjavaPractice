package com.williamtygret.mvprxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.williamtygret.mvprxjava.deps.DaggerDeps;
import com.williamtygret.mvprxjava.deps.Deps;
import com.williamtygret.mvprxjava.networking.NetworkModule;

import java.io.File;

/**
 * Created by williamtygret on 7/24/17.
 */
public class BaseApp extends AppCompatActivity{

    Deps deps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public Deps getDeps() {
        return deps;
    }

}
