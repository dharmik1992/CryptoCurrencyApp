package com.app.cryptocurrencyapp.di.component;

import android.content.Context;


import com.app.cryptocurrencyapp.AppGlobalClass;
import com.app.cryptocurrencyapp.di.module.ContextModule;
import com.app.cryptocurrencyapp.di.module.RetrofitModule;
import com.app.cryptocurrencyapp.di.qualifier.ApplicationContext;
import com.app.cryptocurrencyapp.di.scopes.ApplicationScope;
import com.app.cryptocurrencyapp.retrofit.APIInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    APIInterface getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(AppGlobalClass myApplication);
}
