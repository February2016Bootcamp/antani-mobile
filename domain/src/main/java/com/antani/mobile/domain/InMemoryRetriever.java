package com.antani.mobile.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fgiovinazzo on 03/03/16.
 */
public class InMemoryRetriever implements Retriever {

    private List<String> courses;

    @Override
    public List<String> retrieveCourse() {
        return courses;
    }

    public InMemoryRetriever(List<String> courses) {
        this.courses = courses;
    }
}
