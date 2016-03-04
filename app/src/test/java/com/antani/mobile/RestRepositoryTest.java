package com.antani.mobile;

import com.antani.mobile.adapter.RestRepository;
import com.antani.mobile.domain.Course;
import com.antani.mobile.domain.retriever.Retriever;

import org.junit.Test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RestRepositoryTest {

    @Test
    public void listCoursesFromRestService() throws Exception {
        Retriever restRepository = new RestRepository();
        assertThat(2, is(restRepository.retrieveCourse().size()));
    }

}
