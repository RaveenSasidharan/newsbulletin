package com.panoslice.newsbulletin.manager;

import android.content.Context;
import android.util.Log;

import com.panoslice.newsbulletin.model.NewsRequest;
import com.panoslice.newsbulletin.model.NewsResponse;
import com.panoslice.newsbulletin.network.ApiClient;
import com.panoslice.newsbulletin.network.INewsApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsManagerImpl implements NewsManager
{
    private Context mContext;
    private OnArticleRcvrListener mListener;
    private INewsApiInterface mNewsApiInterface;

    public NewsManagerImpl(Context context)
    {
        this.mContext   = context;
        mNewsApiInterface = ApiClient.getClient().create(INewsApiInterface.class);
    }

    @Override
    public void onNewsResponse(NewsResponse newsResponse)
    {

    }

    @Override
    public void requestForCustomNewsFeed() {

    }

    @Override
    public void requestForAllNewsFeed(NewsRequest newsRequest)
    {
    Call<NewsResponse> call = mNewsApiInterface.getHeadlines(newsRequest.getmCountry(),
                                                                    newsRequest.getmCategory(),
                                                                    newsRequest.getmSources(),
                                                                    newsRequest.getmSearchString(),
                                                                    newsRequest.getmPageNo(),
                                                                    newsRequest.getmPageSize(),
                                                                    newsRequest.getmApiKey());
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                NewsResponse newsResponses = response.body();
                Log.e("test", "news response");
                mListener.onArticleReceived(newsResponses.getArticles());
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("test", "news response failues"+t.toString());

            }
        });


    }

    @Override
    public void requestHeadlines() {

    }

    @Override
    public void requestSourceNewsFeed() {

    }

    @Override
    public void setArticleRcvrListener(OnArticleRcvrListener listener)
    {
        this.mListener  = listener;
    }
}
