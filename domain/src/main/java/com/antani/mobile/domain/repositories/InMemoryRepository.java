package com.antani.mobile.domain.repositories;

import com.antani.mobile.domain.entities.Course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository implements Repository {

    private List<Course> courses;

    private Map<String, Integer> participantsMap = new HashMap();

    public InMemoryRepository(List<Course> courses) {
        this.courses = courses;
        for (Course course : this.courses) {
            participantsMap.put(course.getCode(), 0);
        }
    }

    @Override
    public List<Course> retrieveCourse() {
        return courses;
    }

    @Override
    public boolean addParticipant(String courseCode) {
        if (participantsMap.containsKey(courseCode)) {
            int partecipants = participantsMap.get(courseCode);
            participantsMap.put(courseCode, ++partecipants);
            return true;
        } else {
            return false;
        }
    }

    public int getParticipants(String s) {
        return participantsMap.get(s) == null ? 0 : participantsMap.get(s);
    }
}
