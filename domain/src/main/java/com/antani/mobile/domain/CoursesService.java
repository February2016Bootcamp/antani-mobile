package com.antani.mobile.domain;

import java.util.List;

/**
 * Created by fgiovinazzo on 03/03/16.
 */
public class CoursesService {

    private Retriever retriever;

    public CoursesService(Retriever retriever) {
        this.retriever = retriever;
    }


    public List<String> getCourses() {
        return retriever.retrieveCourse();
    }
}
