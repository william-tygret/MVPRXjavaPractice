package com.williamtygret.cakeproject.modules.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.williamtygret.cakeproject.DI_DependencyInjection.components.DaggerCakeComponent;
import com.williamtygret.cakeproject.DI_DependencyInjection.module.CakeModule;
import com.williamtygret.cakeproject.R;
import com.williamtygret.cakeproject.base.BaseActivity;
import com.williamtygret.cakeproject.modules.home.adapter.CakeAdapter;
import com.williamtygret.cakeproject.mvp.model.Cake;
import com.williamtygret.cakeproject.mvp.presenter.CakePresenter;
import com.williamtygret.cakeproject.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements MainView {

    @Bind(R.id.cake_list) protected RecyclerView mCakeList;
    CakeAdapter mCakeAdapter;

    @Inject
    protected CakePresenter mPresenter;


    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();
        mPresenter.getCakes();
    }

    private void initializeList() {
        mCakeList.setHasFixedSize(true);
        mCakeList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mCakeAdapter = new CakeAdapter(getLayoutInflater());
        mCakeList.setAdapter(mCakeAdapter);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerCakeComponent.builder()
                .applicationComponent(getApplicationComponent())
                .cakeModule(new CakeModule(this))
                .build().inject(this);
    }


    @Override
    public void onCakeLoaded(List<Cake> cakes) {
        mCakeAdapter.addCakes(cakes);
    }

    @Override
    public void onShowDialog(String message){
        showDialog(message);
    }

    @Override
    public void onHideDialog(){
        hideDialog();
    }

    @Override
    public void onShowToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
