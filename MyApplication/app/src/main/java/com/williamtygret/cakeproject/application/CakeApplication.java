package com.williamtygret.cakeproject.application;

import android.app.Application;

import com.williamtygret.cakeproject.DI_DependencyInjection.components.ApplicationComponent;
import com.williamtygret.cakeproject.DI_DependencyInjection.components.DaggerApplicationComponent;
import com.williamtygret.cakeproject.DI_DependencyInjection.module.ApplicationModule;

/**
 * Created by williamtygret on 8/1/17.
 */
public class CakeApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
         mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this, "https://gist.githubusercontent.com")).build();
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
