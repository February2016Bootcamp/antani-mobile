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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShowCoursesTest {

    private Retriever retriever;
    private ShowCourses showCourses;
    private CoursesListView coursesListView;

    @Before
    public void setUp() throws Exception {
        retriever = Mockito.mock(Retriever.class);
        coursesListView = mock(CoursesListView.class);
        showCourses = new ShowCourses(retriever, coursesListView);
    }

    @Test
    public void getEmptyCoursesList() throws Exception {
        when(retriever.retrieveCourse()).thenReturn(Collections.EMPTY_LIST);
        showCourses.showCourses();
        verify(coursesListView).show(Collections.EMPTY_LIST);
    }

    @Test
    public void callCollaboratorToRetrieveCourses() throws Exception {
        showCourses.showCourses();
        Mockito.verify(retriever).retrieveCourse();
    }

    @Test
    public void retrieveCoursesFromMemory() throws Exception {
        ArrayList courses = getManyCourseList(3);
        showCourses = new ShowCourses(new InMemoryRetriever(courses),coursesListView);
        showCourses.showCourses();
        verify(coursesListView).show(courses);
    }

    @Test
    public void showCourses() throws Exception {
        List<String> courses = getManyCourseList(3);
        when(retriever.retrieveCourse()).thenReturn(courses);
        showCourses.showCourses();
        verify(coursesListView).show(courses);
    }

    private ArrayList getManyCourseList(int times) {
        ArrayList courses = new ArrayList();
        for (int i = 0; i < times; i++) {
            courses.add("a course " + i);
        }
        return courses;
    }


}
