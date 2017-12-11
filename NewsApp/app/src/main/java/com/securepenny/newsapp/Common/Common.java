package com.securepenny.newsapp.Common;

import com.securepenny.newsapp.Interface.IconBetterIdeaService;
import com.securepenny.newsapp.Network.NewsService;
import com.securepenny.newsapp.Network.IconBetterIdeaClient;
import com.securepenny.newsapp.Network.RetrofitClient;

/**
 * Created by R041708040 on 12/7/2017.
 */

public class Common {
    private static final String BASE_URL ="https://newsapi.org/";

//    private static final String API_KEY ="9c0598cc782c4404b79e8a1d8013d692";
    private static final String API_KEY ="a7072d9c2ad9495a8dd5cb58a7fd30df";

    public static NewsService getNewsService(){
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService(){
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }

}
