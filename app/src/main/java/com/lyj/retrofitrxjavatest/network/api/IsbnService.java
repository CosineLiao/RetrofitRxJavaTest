package com.lyj.retrofitrxjavatest.network.api;

import com.lyj.retrofitrxjavatest.javaBean.IsbnBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/10/25.
 */

public interface IsbnService
{
    @GET("ISBN")
    Observable<IsbnBean> getIsbnInfo(@Query("sub") String sub);
}
