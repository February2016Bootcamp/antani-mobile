package com.antani.mobile.domain.services;

import com.antani.mobile.domain.CoursesListView;
import com.antani.mobile.domain.retriever.InMemoryRetriever;
import com.antani.mobile.domain.retriever.Retriever;

import java.util.List;

/**
 * Created by fgiovinazzo on 03/03/16.
 */
public class ShowCourses {

    private Retriever retriever;

    public ShowCourses(Retriever retriever) {
        this.retriever = retriever;
    }

    public ShowCourses(InMemoryRetriever inMemoryRetriever, CoursesListView coursesListView) {

    }

    public List<String> getCourses() {
        return retriever.retrieveCourse();
    }
}
