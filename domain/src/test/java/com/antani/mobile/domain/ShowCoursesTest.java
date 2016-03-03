package com.antani.mobile.domain;

import com.antani.mobile.domain.retriever.InMemoryRetriever;
import com.antani.mobile.domain.retriever.Retriever;
import com.antani.mobile.domain.services.ShowCourses;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShowCoursesTest {

    private Retriever retriever;
    private ShowCourses service;

    @Before
    public void setUp() throws Exception {
        retriever = Mockito.mock(Retriever.class);
        service = new ShowCourses(retriever);
    }

    @Test
    public void getEmptyCoursesList() throws Exception {
        Mockito.when(retriever.retrieveCourse()).thenReturn(Collections.EMPTY_LIST);
        List<String> courses = service.getCourses();
        assertThat(courses.isEmpty(), is(true));
    }

    @Test
    public void getNotEmptyCoursesList() throws Exception {
        Mockito.when(retriever.retrieveCourse()).thenReturn(getManyCourseList(1));
        List<String> courses = service.getCourses();
        assertThat(courses.isEmpty(), is(false));
    }

    @Test
    public void callCollaboratorToRetrieveCourses() throws Exception {
        service.getCourses();
        Mockito.verify(retriever).retrieveCourse();
    }

    @Test
    public void retrieveCoursesFromMemory() throws Exception {
        service = new ShowCourses(new InMemoryRetriever(getManyCourseList(3)));
        assertThat(3, is(service.getCourses().size()));
    }

    private ArrayList getManyCourseList(int times) {
        ArrayList courses = new ArrayList();
        for (int i = 0; i < times; i++) {
            courses.add("a course " + i);
        }
        return courses;
    }


}
