package com.example.newsapp;

public class News {

    private String mCategory;


    private String mAbout;


    private String mDate;


    private String mContributor;


    private String mImg;


    private String mUrl;



    public News(String category, String about, String date, String contributor, String img, String url) {
        mCategory = category;
        mAbout = about;
        mDate = date;
        mContributor = contributor;
        mImg = img;
        mUrl = url;
    }


    public String getmCategory(){
        return mCategory;
    }
    public String getmAbout(){
        return mAbout;
    }
    public String getmDate(){
        return mDate;
    }
    public String getmContributor(){
        return mContributor;
    }
    public String getmImg(){
        return mImg;
    }
    public String getmUrl(){
        return mUrl;
    }
}
