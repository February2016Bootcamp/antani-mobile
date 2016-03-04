package com.antani.mobile;

import com.antani.mobile.adapter.RestRepository;
import com.antani.mobile.domain.retriever.Retriever;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;


public class RestRepositoryTest {

    @Test
    public void listCoursesFromRestService() throws Exception {
        Retriever restRepository = new RestRepository();
        assertTrue(restRepository.retrieveCourse().size() >= 0);
    }

}
