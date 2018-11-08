package com.panoslice.newsbulletin.manager;

import com.panoslice.newsbulletin.model.Article;
import com.panoslice.newsbulletin.model.NewsRequest;
import com.panoslice.newsbulletin.model.NewsResponse;

import java.util.List;

public interface NewsManager
{
    public interface OnArticleRcvrListener
    {
        void onArticleReceived(List<Article> articleList);
    }

    void onNewsResponse(NewsResponse newsResponse);
    void requestForCustomNewsFeed();
    void requestForAllNewsFeed(NewsRequest newsRequest);
    void requestHeadlines();
    void requestSourceNewsFeed();
    void setArticleRcvrListener(OnArticleRcvrListener listener);
}
