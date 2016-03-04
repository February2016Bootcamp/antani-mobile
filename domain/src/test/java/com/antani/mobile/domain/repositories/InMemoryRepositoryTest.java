package com.antani.mobile.domain.repositories;

import com.antani.mobile.domain.entities.Course;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by fgiovinazzo on 04/03/16.
 */
public class InMemoryRepositoryTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void retrieveCourse() throws Exception
    {
        InMemoryRepository repository= new InMemoryRepository(getManyCourseList(5));
        assertThat(repository.retrieveCourse().size(), is(5));
    }

    @Test
    public void subscribe() throws Exception {
        InMemoryRepository repository= new InMemoryRepository(getManyCourseList(5));
        assertThat(repository.getPartecipants("1"), is(0));
        repository.addPartecipant("1");

        assertThat(repository.getPartecipants("1"), is(1));


    }

    private ArrayList<com.antani.mobile.domain.entities.Course> getManyCourseList(int times) {
        ArrayList courses = new ArrayList();
        for (int i = 0; i < times; i++) {
            Course e = new Course("a course " + i);
            e.setCode(""+i);
            courses.add(e);
        }
        return courses;
    }
}