package com.antani.mobile.adapter.repository;

import com.antani.mobile.domain.entities.Course;
import com.antani.mobile.domain.repositories.Repository;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RestRepository implements Repository {
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
