package com.williamtygret.cakeproject.mvp.view;

import com.williamtygret.cakeproject.mvp.model.Cake;

import java.util.List;

/**
 * Created by williamtygret on 8/1/17.
 */
public interface MainView extends BaseView{
    void onCakeLoaded(List<Cake> cakes);

    void onShowDialog(String message);

    void onHideDialog();
    void onShowToast(String message);


}
