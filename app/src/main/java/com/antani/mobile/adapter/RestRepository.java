package com.antani.mobile.adapter;

import com.antani.mobile.domain.Course;
import com.antani.mobile.domain.retriever.Retriever;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RestRepository implements Retriever {
    @Override
    public List<Course> retrieveCourse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://antani-be.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        try {
            return service.getCourses().execute().body();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    interface Service {
        @GET("courses")
        Call<List<Course>> getCourses();
    }
}
