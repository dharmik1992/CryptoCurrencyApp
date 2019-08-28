package com.app.cryptocurrencyapp.di.component;

import android.content.Context;


import com.app.cryptocurrencyapp.MainActivity;
import com.app.cryptocurrencyapp.di.module.AdapterModule;
import com.app.cryptocurrencyapp.di.module.MainActivityMvpModule;
import com.app.cryptocurrencyapp.di.qualifier.ActivityContext;
import com.app.cryptocurrencyapp.di.scopes.ActivityScope;

import dagger.Component;


@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();
    void injectMainActivity(MainActivity mainActivity);
}
