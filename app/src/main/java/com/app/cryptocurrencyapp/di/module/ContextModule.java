package com.app.cryptocurrencyapp.di.module;

import android.content.Context;


import com.app.cryptocurrencyapp.di.qualifier.ApplicationContext;
import com.app.cryptocurrencyapp.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
