package com.antani.mobile.domain.views;

import com.antani.mobile.domain.entities.Course;

import java.util.List;

public interface CoursesListView {
    void show(List<Course> courses);
}
