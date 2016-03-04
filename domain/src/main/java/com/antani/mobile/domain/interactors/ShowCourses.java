package com.antani.mobile.domain.interactors;

import com.antani.mobile.domain.views.CoursesListView;
import com.antani.mobile.domain.repositories.Repository;

/**
 * Created by fgiovinazzo on 03/03/16.
 */
public class ShowCourses {

    private Repository retriever;
    private CoursesListView coursesListView;

    public ShowCourses(Repository retriever, CoursesListView coursesListView) {
        this.retriever = retriever;
        this.coursesListView = coursesListView;
    }

    public void showCourses() {
        coursesListView.show(retriever.retrieveCourse());
    }
}
