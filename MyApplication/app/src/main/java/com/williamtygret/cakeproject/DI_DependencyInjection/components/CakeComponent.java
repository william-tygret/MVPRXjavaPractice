package com.williamtygret.cakeproject.DI_DependencyInjection.components;

import com.williamtygret.cakeproject.DI_DependencyInjection.module.CakeModule;
import com.williamtygret.cakeproject.DI_DependencyInjection.scope.PerActivity;
import com.williamtygret.cakeproject.modules.home.MainActivity;
import com.williamtygret.cakeproject.mvp.view.MainView;

import dagger.Component;

/**
 * Created by williamtygret on 8/1/17.
 */
@PerActivity
@Component (modules = CakeModule.class, dependencies = ApplicationComponent.class)
public interface CakeComponent {

    void inject(MainActivity activity);

}
