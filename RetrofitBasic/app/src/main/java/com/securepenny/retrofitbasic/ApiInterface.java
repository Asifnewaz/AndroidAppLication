package com.securepenny.retrofitbasic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by R041708040 on 11/29/2017.
 */

public interface ApiInterface {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
    );
}
