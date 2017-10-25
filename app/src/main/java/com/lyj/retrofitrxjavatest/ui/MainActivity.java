package com.lyj.retrofitrxjavatest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.lyj.retrofitrxjavatest.R;
import com.lyj.retrofitrxjavatest.javaBean.Book;
import com.lyj.retrofitrxjavatest.network.ApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private String TAG = "MainActivity";

    @BindView(R.id.btn_get_data)
    Button btnGetData;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



    }


    @OnClick(R.id.btn_get_data)
    public void onViewClicked()
    {
        ApiService.SingleTonHolder.getInstance().getBookApi().searchBook("金瓶梅", null, 0, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Book>()
                {
                    @Override
                    public void onCompleted()
                    {

                    }

                    @Override
                    public void onError(Throwable e)
                    {

                    }

                    @Override
                    public void onNext(Book book)
                    {

                    }
                });
    }
}
