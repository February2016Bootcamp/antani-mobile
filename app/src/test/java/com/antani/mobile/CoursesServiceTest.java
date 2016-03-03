package com.antani.mobile;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(retriever.retrieveCourse()).thenReturn(Collections.EMPTY_LIST);
        List<String> courses = service.getCourses();
        assertThat(courses.isEmpty(), is(true));
    }

    @Test
    public void getNotEmptyCoursesList() throws Exception {
        when(retriever.retrieveCourse()).thenReturn(getOneCourseList());
        List<String> courses = service.getCourses();
        assertThat(courses.isEmpty(), is(false));
    }

    @Test
    public void callCollaboratorToRetrieveCourses() throws Exception {
        service.getCourses();
        verify(retriever).retrieveCourse();
    }

    private ArrayList getOneCourseList() {
        ArrayList courses = new ArrayList();
        courses.add("a course");
        return courses;
    }

    private class CoursesService {

        private Retriever retriever;

        public CoursesService(Retriever retriever) {
            this.retriever = retriever;
        }


        public List<String> getCourses() {
            return retriever.retrieveCourse();
        }
    }

    private class Retriever {
        public List<String> retrieveCourse() {
            return null;
        }
    }
}
