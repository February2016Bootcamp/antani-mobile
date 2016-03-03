package com.antani.mobile.domain;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoursesServiceTest {

    private Retriever retriever;
    private CoursesService service;

    @Before
    public void setUp() throws Exception {
        retriever = Mockito.mock(Retriever.class);
        service = new CoursesService(retriever);
    }

    @Test
    public void getEmptyCoursesList() throws Exception {
        Mockito.when(retriever.retrieveCourse()).thenReturn(Collections.EMPTY_LIST);
        List<String> courses = service.getCourses();
        Assert.assertThat(courses.isEmpty(), CoreMatchers.is(true));
    }

    @Test
    public void getNotEmptyCoursesList() throws Exception {
        Mockito.when(retriever.retrieveCourse()).thenReturn(getOneCourseList());
        List<String> courses = service.getCourses();
        Assert.assertThat(courses.isEmpty(), CoreMatchers.is(false));
    }

    @Test
    public void callCollaboratorToRetrieveCourses() throws Exception {
        service.getCourses();
        Mockito.verify(retriever).retrieveCourse();
    }

    private ArrayList getOneCourseList() {
        ArrayList courses = new ArrayList();
        courses.add("a course");
        return courses;
    }

}
