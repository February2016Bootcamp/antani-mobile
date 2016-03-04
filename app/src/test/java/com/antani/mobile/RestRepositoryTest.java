package com.antani.mobile;

import com.antani.mobile.adapter.repository.RestRepository;
import com.antani.mobile.domain.repositories.Repository;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;


public class RestRepositoryTest {

    @Test
    public void listCoursesFromRestService() throws Exception {
        Repository restRepository = new RestRepository();
        assertTrue(restRepository.retrieveCourse().size() >= 0);
    }

    @Test
    public void subscribe() throws Exception {
        RestRepository restRepository = new RestRepository();
        assertTrue(restRepository.addParticipant("02"));
    }
}
