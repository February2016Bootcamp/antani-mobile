package com.antani.mobile.domain;

import com.antani.mobile.domain.interactors.Registration;
import com.antani.mobile.domain.repositories.Repository;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RegistrationTest {


    private Repository repository;
    private Registration registration;

    @Before
    public void setUp() throws Exception {

        repository = mock(Repository.class);
        registration = new Registration(repository);
    }

    @Test
    public void success() throws Exception {

        when(repository.addParticipant(anyString())).thenReturn(true);

        assertThat( registration.subscribe("123"), is(true));

        verify(repository, times(1)).addParticipant(anyString());
    }

    @Test
    public void failure() throws Exception {

        when(repository.addParticipant(anyString())).thenReturn(false);

        assertThat( registration.subscribe("456"), is(false));

        verify(repository, times(1)).addParticipant(anyString());
    }
}
