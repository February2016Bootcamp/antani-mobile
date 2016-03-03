package com.antani.mobile.domain.services;

import com.antani.mobile.domain.CoursesListView;
import com.antani.mobile.domain.retriever.Retriever;

/**
 * Created by fgiovinazzo on 03/03/16.
 */
public class ShowCourses {

    private Retriever retriever;
    private CoursesListView coursesListView;

    public ShowCourses(Retriever retriever, CoursesListView coursesListView) {
        this.retriever = retriever;
        this.coursesListView = coursesListView;
    }

    public void showCourses() {
        coursesListView.show(retriever.retrieveCourse());
    }
}
