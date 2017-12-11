package com.securepenny.newsapp.Network;

import com.securepenny.newsapp.model.Website;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by R041708040 on 12/7/2017.
 */

public interface NewsService {

//    @GET("v2/top-headlines?sources=techcrunch&apiKey=9c0598cc782c4404b79e8a1d8013d692")
//    Call<Website> getNewsService();

    @GET("v1/sources?language=en")
    Call<Website> getSource();

}
