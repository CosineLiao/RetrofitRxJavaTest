package com.lyj.retrofitrxjavatest.network.api;

import com.lyj.retrofitrxjavatest.javaBean.Book;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/10/25.
 */

public interface BookService
{
    @GET("book/search")
    Observable<Book> searchBook(@Query("q") String bookName,
                                @Query("tag") String tag,
                                @Query("start") int start,
                                @Query("count") int count);
}
