package com.antani.mobile.domain.repositories;

import com.antani.mobile.domain.entities.Course;

import java.util.List;

public class InMemoryRepository implements Repository {

    private List<Course> courses;

    public InMemoryRepository(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public List<Course> retrieveCourse() {
        return courses;
    }

    @Override
    public boolean addPartecipant(String courseCode) {
        return false;
    }

}
