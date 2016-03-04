package com.antani.mobile.domain.interactors;

import com.antani.mobile.domain.repositories.Repository;

public class Registration {

    private Repository repository;

    public Registration(Repository repository) {
        this.repository = repository;
    }

    public boolean subscribe(String courseCode) {

        return repository.addParticipant(courseCode);
    }
}
