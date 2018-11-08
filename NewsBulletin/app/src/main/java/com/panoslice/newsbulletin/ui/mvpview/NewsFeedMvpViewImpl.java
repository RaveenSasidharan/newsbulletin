package com.panoslice.newsbulletin.ui.mvpview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.panoslice.newsbulletin.R;
import com.panoslice.newsbulletin.model.Article;
import com.panoslice.newsbulletin.ui.adapter.NewsFeedAdapter;
import com.panoslice.newsbulletin.ui.mvpview.NewsFeedMvpView;

import java.util.List;

public class NewsFeedMvpViewImpl implements NewsFeedMvpView
{
    private View mRootView;
    private NewsFeedMvpView.NewsFeedMvpViewListener mNewsFeedMvpViewListener;

    private RecyclerView mRecyclerView;
    private NewsFeedAdapter mNewsFeedAdapter;



    public NewsFeedMvpViewImpl(LayoutInflater inflater, ViewGroup container)
    {
        mRootView   = inflater.inflate(R.layout.mvc_view_news_feed, container, false);
        mRecyclerView   = mRootView.findViewById(R.id.feedRecycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRootView.getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void populateNewsFeed(List<Article> articleList)
    {
        Log.e("test", "news populateNewsFeed"+articleList.size());
        mNewsFeedAdapter = new NewsFeedAdapter(articleList, mNewsFeedMvpViewListener);
        mRecyclerView.setAdapter(mNewsFeedAdapter);

    }

    @Override
    public void setNewsFeedMvpViewListener(NewsFeedMvpViewListener listener) {
        mNewsFeedMvpViewListener = listener;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }
}
