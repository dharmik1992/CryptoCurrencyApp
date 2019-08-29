package com.app.cryptocurrencyapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.app.cryptocurrencyapp.di.component.ApplicationComponent;
import com.app.cryptocurrencyapp.di.component.DaggerMainActivityComponent;
import com.app.cryptocurrencyapp.di.component.MainActivityComponent;
import com.app.cryptocurrencyapp.di.module.MainActivityContextModule;
import com.app.cryptocurrencyapp.di.module.MainActivityMvpModule;
import com.app.cryptocurrencyapp.di.qualifier.ActivityContext;
import com.app.cryptocurrencyapp.di.qualifier.ApplicationContext;
import com.app.cryptocurrencyapp.mvp.MainActivityContract;
import com.app.cryptocurrencyapp.mvp.PresenterImpl;
import com.app.cryptocurrencyapp.pojo.CryptoData;
import com.app.cryptocurrencyapp.recyclerAdapter.RecyclerViewAdapter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View, RecyclerViewAdapter.ClickListener {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
 //   private ProgressBar dd;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;


    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Inject
    PresenterImpl presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ApplicationComponent applicationComponent = AppGlobalClass.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .mainActivityMvpModule(new MainActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
        recyclerView.setAdapter(recyclerViewAdapter);
        progressBar = findViewById(R.id.progressBar);

        presenter.loadData();


    }

    @Override
    public void launchIntent(String name) {
        Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
        // startActivity(new Intent(activityContext, DetailActivity.class).putExtra("name", name));
    }

    @Override
    public void showData(List<CryptoData> data) {
        recyclerViewAdapter.setData(data);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
