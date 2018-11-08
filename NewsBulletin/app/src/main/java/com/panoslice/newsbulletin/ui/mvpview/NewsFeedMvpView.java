package com.panoslice.newsbulletin.ui.mvpview;

import com.panoslice.newsbulletin.model.Article;
import com.panoslice.newsbulletin.model.NewsResponse;
import com.panoslice.newsbulletin.ui.base.MvpView;

import java.util.List;

public interface NewsFeedMvpView extends MvpView
{
    public interface NewsFeedMvpViewListener
    {   void onViewNewsClick(Article article);
    }

    void populateNewsFeed(List<Article> articleList);

    void setNewsFeedMvpViewListener(NewsFeedMvpViewListener listener);

}
