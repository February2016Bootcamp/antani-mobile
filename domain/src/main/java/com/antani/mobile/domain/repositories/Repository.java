package com.antani.mobile.domain.repositories;

import com.antani.mobile.domain.entities.Course;

import java.util.List;

public interface Repository {
    List<Course> retrieveCourse();

    boolean addParticipant(String courseCode);
}
