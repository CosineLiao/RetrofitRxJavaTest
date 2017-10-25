package com.lyj.retrofitrxjavatest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.lyj.retrofitrxjavatest.R;
import com.lyj.retrofitrxjavatest.javaBean.Book;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/25.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{
    private List<Book.BooksBean> mBooksList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_recycler_view, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Book.BooksBean booksBean = mBooksList.get(position);

    }

    @Override
    public int getItemCount()
    {
        return mBooksList == null ? 0 : mBooksList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.image_view)
        ImageView imageView;
        @BindView(R.id.text_book_title)
        TextView textBookTitle;
        @BindView(R.id.text_book_author)
        TextView textBookAuthor;
        @BindView(R.id.text_grade)
        TextView textGrade;
        @BindView(R.id.text_summary)
        TextView textSummary;

        View itemView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
