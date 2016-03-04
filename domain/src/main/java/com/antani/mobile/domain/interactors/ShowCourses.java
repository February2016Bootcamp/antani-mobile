package com.antani.mobile.domain.interactors;

import com.antani.mobile.domain.views.CoursesListView;
import com.antani.mobile.domain.repositories.Repository;


public class ShowCourses {

    private Repository repository;
    private CoursesListView coursesListView;

    public ShowCourses(Repository repository, CoursesListView coursesListView) {
        this.repository = repository;
        this.coursesListView = coursesListView;
    }

    public void showCourses() {
        coursesListView.show(repository.retrieveCourse());
    }
}
