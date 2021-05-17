package com.example.hidoctest.API;

import com.example.hidoctest.model.ArticlesData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Post {


    @GET("everything?q=bitcoin&from=2021-04-17&sortBy=publishedAt&apiKey=bf85254767914aaebb1391127d01abc6")
    Call<ArticlesData>getArticles();

}
