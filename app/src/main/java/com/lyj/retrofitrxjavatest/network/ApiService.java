package com.lyj.retrofitrxjavatest.network;

import android.util.Log;

import com.lyj.retrofitrxjavatest.javaBean.IsbnBean;
import com.lyj.retrofitrxjavatest.network.api.BookService;
import com.lyj.retrofitrxjavatest.network.api.IsbnService;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/10/25.
 */

public class ApiService
{
    private Retrofit mRetrofit;

    public static class SingleTonHolder
    {
        private static ApiService mInstance = new ApiService();

        public static ApiService getInstance()
        {
            if (mInstance.mRetrofit == null)
            {
                mInstance.mRetrofit = new Retrofit.Builder()
                        .baseUrl("https://api.douban.com/v2/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
            }

            return mInstance;
        }
    }

    public IsbnService getIsbnApi()
    {
        Log.i("RetrofitUtils", "mRetrofit=" + mRetrofit);
        if (mRetrofit != null)
        {
            return mRetrofit.create(IsbnService.class);
        }

        return null;
    }

    public BookService getBookApi()
    {
        return mRetrofit.create(BookService.class);
    }
}
