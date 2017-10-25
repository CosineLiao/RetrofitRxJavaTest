package com.lyj.retrofitrxjavatest.utils;

import com.lyj.retrofitrxjavatest.javaBean.IsbnBean;
import com.lyj.retrofitrxjavatest.network.ApiService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/10/25.
 */

public class RetrofitUtils
{
    // 在这个方法体内执行网络请求，返回一个被观察者
    public static <T> Observable<T> create(final Call<T> call)
    {
        return Observable.unsafeCreate(new Observable.OnSubscribe<T>()
        {
            @Override
            public void call(Subscriber<? super T> subscriber)
            {
                try
                {
                    Response<T> response = call.execute(); // 同步请求
                    if (response.isSuccessful())
                    {
                        subscriber.onNext(response.body());
                        subscriber.onCompleted();
                    }
                    else
                    {
                        subscriber.onError(new IOException());
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
        });
    }

    public static Observable<IsbnBean> getData(String sub)
    {
        return ApiService.SingleTonHolder.getInstance().getIsbnApi().getIsbnInfo(sub);
    }
}
