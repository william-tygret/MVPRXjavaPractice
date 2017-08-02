package com.williamtygret.cakeproject.DI_DependencyInjection.components;

import android.content.Context;

import com.williamtygret.cakeproject.DI_DependencyInjection.module.ApplicationModule;
import com.williamtygret.cakeproject.application.CakeApplication;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by williamtygret on 8/1/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();

}
