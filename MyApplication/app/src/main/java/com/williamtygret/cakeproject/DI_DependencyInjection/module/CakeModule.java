package com.williamtygret.cakeproject.DI_DependencyInjection.module;

import com.williamtygret.cakeproject.DI_DependencyInjection.scope.PerActivity;
import com.williamtygret.cakeproject.api.CakeAPIService;
import com.williamtygret.cakeproject.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by williamtygret on 8/1/17.
 */
@Module
public class CakeModule {

    private MainView mView;

    public CakeModule(MainView view){
        mView = view;
    }

    @PerActivity
    @Provides
    CakeAPIService provideAPIService(Retrofit retrofit){
        return retrofit.create(CakeAPIService.class);
    }

    @PerActivity
    @Provides
    MainView provideView(){
        return mView;
    }

}
