package com.app.cryptocurrencyapp.mvp;



import com.app.cryptocurrencyapp.pojo.CryptoData;

import java.util.List;

public interface MainActivityContract {
    interface View {
        void showData(List<CryptoData> data);

        void showError(String message);

        void showComplete();

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void loadData();
    }
}
