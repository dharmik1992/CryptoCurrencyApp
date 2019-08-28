package com.app.cryptocurrencyapp.retrofit;


import com.app.cryptocurrencyapp.pojo.CryptoData;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIInterface {

    @GET("ticker/?")
    Observable<List<CryptoData>> getData(@Query("limit") String limit);
}
