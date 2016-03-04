package com.antani.mobile.domain.views;

import com.antani.mobile.domain.entities.Course;

import java.util.List;

/**
 * Created by fgiovinazzo on 03/03/16.
 */
public interface CoursesListView {
    void show(List<Course> courses);
}
