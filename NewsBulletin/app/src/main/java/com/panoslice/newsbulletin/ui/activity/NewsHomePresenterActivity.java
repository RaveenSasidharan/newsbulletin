package com.panoslice.newsbulletin.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.panoslice.newsbulletin.R;
import com.panoslice.newsbulletin.manager.NewsManager;
import com.panoslice.newsbulletin.manager.NewsManagerImpl;
import com.panoslice.newsbulletin.model.Article;
import com.panoslice.newsbulletin.model.NewsRequest;
import com.panoslice.newsbulletin.ui.mvpview.NewsFeedMvpView;
import com.panoslice.newsbulletin.ui.mvpview.NewsFeedMvpViewImpl;

import java.util.List;

public class NewsHomePresenterActivity extends AppCompatActivity
{
    private final static String TAG = NewsHomePresenterActivity.class.getSimpleName();

    private NewsFeedMvpViewImpl mNewsFeedMvpViewImpl;
    private NewsManagerImpl mNewsManagerImpl;

    ///
    //
    ///
    private NewsManager.OnArticleRcvrListener mArticleRcvrListener = new NewsManager.OnArticleRcvrListener() {
        @Override
        public void onArticleReceived(List<Article> articleList) {
            Log.e("test", "news mArticleRcvrListener");
            mNewsFeedMvpViewImpl.populateNewsFeed(articleList);
        }
    };//end OnArticleRcvrListener

    ///
    //
    ///
    private NewsFeedMvpView.NewsFeedMvpViewListener mNewsFeedViewListener = new NewsFeedMvpView.NewsFeedMvpViewListener() {

        @Override
        public void onViewNewsClick(Article article) {

        }

    };//end NewsFeedMvpViewListener

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mNewsFeedMvpViewImpl = new NewsFeedMvpViewImpl(getLayoutInflater(), null);
        mNewsFeedMvpViewImpl.setNewsFeedMvpViewListener(mNewsFeedViewListener);

        mNewsManagerImpl     = new NewsManagerImpl(this);
        mNewsManagerImpl.setArticleRcvrListener(mArticleRcvrListener);

        setContentView(mNewsFeedMvpViewImpl.getRootView());

        NewsRequest newsRequest = new NewsRequest();
        newsRequest.setmPageNo(1);
        newsRequest.setmPageSize(20);
        newsRequest.setmCountry("us");
        newsRequest.setmCategory("science");
        newsRequest.setmApiKey(getResources().getString(R.string.news_api_key));
        mNewsManagerImpl.requestForAllNewsFeed(newsRequest);
    }





}
