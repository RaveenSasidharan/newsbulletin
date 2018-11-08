package com.panoslice.newsbulletin.model;

import com.google.gson.annotations.SerializedName;

public class NewsRequest
{
    @SerializedName("country")
    private String mCountry;

    @SerializedName("category")
    private String mCategory;

    @SerializedName("sources")
    private String mSources;

    @SerializedName("q")
    private String mSearchString;

    @SerializedName("page")
    private int mPageNo;

    @SerializedName("pageSize")
    private int mPageSize;

    @SerializedName("apiKey")
    private String mApiKey;

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmSources(String mSources) {
        this.mSources = mSources;
    }

    public String getmSources() {
        return mSources;
    }

    public void setmSearchString(String mSearchString) {
        this.mSearchString = mSearchString;
    }

    public String getmSearchString() {
        return mSearchString;
    }

    public void setmPageSize(int mPageSize) {
        this.mPageSize = mPageSize;
    }

    public int getmPageSize() {
        return mPageSize;
    }

    public void setmPageNo(int mPageNo) {
        this.mPageNo = mPageNo;
    }

    public int getmPageNo() {
        return mPageNo;
    }

    public void setmApiKey(String mApiKey) {
        this.mApiKey = mApiKey;
    }

    public String getmApiKey() {
        return mApiKey;
    }

}

