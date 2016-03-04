package com.antani.mobile.adapter.repository;

import com.antani.mobile.domain.entities.Course;
import com.antani.mobile.domain.repositories.Repository;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    @Override
    public boolean addParticipant(String courseCode) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://antani-be.herokuapp.com")
                .build();
        Service service = retrofit.create(Service.class);
        try {
            return service.subscribeCourse(courseCode).execute().isSuccess();
        } catch (IOException e) {
            return false;
        }
    }

    interface Service {
        @GET("courses")
        Call<List<Course>> getCourses();

        @POST("courses/{code}/participants")
        Call<Void> subscribeCourse(@Path("code") String code);
    }
}
