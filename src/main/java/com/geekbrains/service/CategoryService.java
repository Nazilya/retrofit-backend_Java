package com.geekbrains.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import com.geekbrains.dto.Category;

public interface CategoryService {
    @GET("categories/{id}")
    Call<Category> getCategory(@Path("id") Integer id) ;

}
