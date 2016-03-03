package com.antani.mobile.domain.retriever;

import com.antani.mobile.domain.Course;

import java.util.List;

/**
 * Created by fgiovinazzo on 03/03/16.
 */
public interface Retriever {
    List<Course> retrieveCourse();
}
