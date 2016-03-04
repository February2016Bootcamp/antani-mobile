package com.antani.mobile.domain.repositories;

import com.antani.mobile.domain.entities.Course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository implements Repository {

    private List<Course> courses;

    private Map<String,Integer> partecipantsMap = new HashMap();

    public InMemoryRepository(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public List<Course> retrieveCourse() {
        return courses;
    }

    @Override
    public boolean addPartecipant(String courseCode) {
        int partecipants = partecipantsMap.get(courseCode)== null?0:partecipantsMap.get(courseCode);
        partecipantsMap.put(courseCode,++partecipants);
        return true;
    }

    public int getPartecipants(String s) {
        return partecipantsMap.get(s) == null? 0 : partecipantsMap.get(s);
    }
}
