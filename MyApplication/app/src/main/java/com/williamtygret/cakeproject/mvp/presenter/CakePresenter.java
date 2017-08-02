package com.williamtygret.cakeproject.mvp.presenter;

import com.williamtygret.cakeproject.api.CakeAPIService;
import com.williamtygret.cakeproject.base.BaseActivity;
import com.williamtygret.cakeproject.base.BasePresenter;
import com.williamtygret.cakeproject.mapper.CakeMapper;
import com.williamtygret.cakeproject.mvp.model.Cake;
import com.williamtygret.cakeproject.mvp.model.CakesResponse;
import com.williamtygret.cakeproject.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * Created by williamtygret on 8/1/17.
 */
public class CakePresenter extends BasePresenter<MainView> implements Observer<CakesResponse> {

    @Inject protected CakeAPIService mCakeAPIService;
    @Inject protected CakeMapper mCakeMapper;

    @Inject
    public CakePresenter(){

    }

    public void getCakes(){
        getView().onShowDialog("Loading Cakes...");
        Observable<CakesResponse> cakeResponseObservable = mCakeAPIService.getCakes();
        subscribe(cakeResponseObservable, this);
    }

    @Override
    public void onCompleted(){
        getView().onHideDialog();
        getView().onShowToast("Loading Complete!");
    }

    @Override
    public void onError(Throwable e){
        getView().onHideDialog();
        getView().onShowToast("Error Loading Cakes");
    }

    @Override
    public void onNext(CakesResponse cakesResponse) {
        List<Cake> cakes = mCakeMapper.mapCakes(cakesResponse);
        getView().onCakeLoaded(cakes);
    }


}
