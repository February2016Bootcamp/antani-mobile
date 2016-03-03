package com.antani.mobile.domain.retriever;

import com.antani.mobile.domain.Course;

import java.util.List;

/**
 * Created by fgiovinazzo on 03/03/16.
 */
public class InMemoryRetriever implements Retriever {

    private List<Course> courses;

    @Override
    public List<Course> retrieveCourse() {
        return courses;
    }

    public InMemoryRetriever(List<Course> courses) {
        this.courses = courses;
    }
}
