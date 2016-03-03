package com.antani.mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.antani.mobile.domain.Course;
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

        List<Course> courses = Arrays.asList(new Course("pippo"), new Course("pluto"), new Course("ordine 3"));
        InMemoryRetriever retriever = new InMemoryRetriever(courses);

        ShowCourses showCourses = new ShowCourses(retriever, this);
        showCourses.showCourses();
    }

    @Override
    public void show(List<Course> courses) {
        String message = "";
        for (Course course : courses) {
             message += course.getTitle() + "\n";
        }
        Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
