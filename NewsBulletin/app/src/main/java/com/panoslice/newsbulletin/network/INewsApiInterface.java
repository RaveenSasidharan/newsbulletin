package com.panoslice.newsbulletin.network;

import com.panoslice.newsbulletin.model.NewsRequest;
import com.panoslice.newsbulletin.model.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface INewsApiInterface
{
    //@FormUrlEncoded
    @GET("v2/top-headlines")
    Call<NewsResponse> getHeadlines(@Query("country") String country,
                                          @Query("caregory") String category,
                                          @Query("source") String source,
                                          @Query("q") String search,
                                          @Query("page") int page,
                                          @Query("pageSize") int pageSize,
                                          @Query("apiKey") String key);

    @GET("v2/everything")
    Call<List<NewsResponse>> getEverything(@Body NewsRequest newsRequest);

    @GET("v2/sources")
    Call<List<NewsResponse>> getSourceNews(@Body NewsRequest newsRequest);
}
