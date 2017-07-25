package com.williamtygret.mvprxjava.deps;

import com.williamtygret.mvprxjava.main.MainActivity;
import com.williamtygret.mvprxjava.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class,})

/**
 * Created by williamtygret on 7/24/17.
 */
public interface Deps {

    void inject(MainActivity mainActivity);
}


