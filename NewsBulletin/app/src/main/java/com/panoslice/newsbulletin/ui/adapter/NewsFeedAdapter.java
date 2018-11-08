package com.panoslice.newsbulletin.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.panoslice.newsbulletin.R;
import com.panoslice.newsbulletin.model.Article;
import com.panoslice.newsbulletin.ui.mvpview.NewsFeedMvpView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.NewsHolder>
{
    private List<Article> mArticleList;
    private NewsFeedMvpView.NewsFeedMvpViewListener  mNewsFeedMvpViewListener;

    public class NewsHolder extends RecyclerView.ViewHolder
    {
        public View mNewsView;
        public TextView mSlNoTV;
        public TextView mSourceTV;
        public TextView mTitleTV;
        public ImageView mSourceImageView;
        public NewsHolder(@NonNull View itemView)
        {
            super(itemView);

            this.mNewsView = itemView;
            this.mSlNoTV   = itemView.findViewById(R.id.slNo);
            this.mSourceTV   = itemView.findViewById(R.id.source);
            this.mTitleTV   = itemView.findViewById(R.id.title);
            this.mSourceImageView   = itemView.findViewById(R.id.newsImage);
        }
    }


    public NewsFeedAdapter(List<Article> articleList,
                           NewsFeedMvpView.NewsFeedMvpViewListener feedMvpViewListener)
    {
        this.mNewsFeedMvpViewListener       = feedMvpViewListener;
        this.mArticleList   = articleList;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_news_item, parent, false);

        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, final int position)
    {
        holder.mSlNoTV.setText(""+(position + 1));
        holder.mTitleTV.setText(mArticleList.get(position).getTitle());
        holder.mSourceTV.setText(mArticleList.get(position).getSource().getName());
        holder.mTitleTV.setText(mArticleList.get(position).getTitle());

        Picasso.get()
                .load(mArticleList.get(position).getUrlToImage())
                .resize(50, 50)
                .centerCrop()
                .into(holder.mSourceImageView);

        holder.mNewsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewsFeedMvpViewListener.onViewNewsClick(mArticleList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.e("test", "size"+mArticleList.size());
        return mArticleList.size();
    }
}
