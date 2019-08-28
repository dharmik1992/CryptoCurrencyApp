package com.app.cryptocurrencyapp;

import android.app.Activity;
import android.app.Application;

import com.app.cryptocurrencyapp.di.component.ApplicationComponent;
import com.app.cryptocurrencyapp.di.component.DaggerApplicationComponent;
import com.app.cryptocurrencyapp.di.module.ContextModule;

/**
 * Created by user on 28/08/2019.
 */

public class AppGlobalClass extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);

    }

    public static AppGlobalClass get(Activity activity) {
        return (AppGlobalClass) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
