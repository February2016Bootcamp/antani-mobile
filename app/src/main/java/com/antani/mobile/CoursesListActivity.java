package com.antani.mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.antani.mobile.domain.CoursesListView;
import com.antani.mobile.domain.retriever.InMemoryRetriever;
import com.antani.mobile.domain.services.ShowCourses;

import java.util.Arrays;
import java.util.List;

public class CoursesListActivity extends AppCompatActivity implements CoursesListView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);

        List<String> courses = Arrays.asList("pippo", "pluto", "ordine 3");
        InMemoryRetriever retriever = new InMemoryRetriever(courses);

        ShowCourses showCourses = new ShowCourses(retriever, this);
        showCourses.showCourses();
    }

    @Override
    public void show(List<String> courses) {
        String message = "";
        for (String course : courses) {
             message += course;
        }
        Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
