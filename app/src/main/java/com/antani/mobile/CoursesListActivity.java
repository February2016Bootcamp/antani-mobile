package com.antani.mobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.antani.mobile.adapter.RestRepository;
import com.antani.mobile.domain.Course;
import com.antani.mobile.domain.CoursesListView;
import com.antani.mobile.domain.services.ShowCourses;

import java.util.List;

public class CoursesListActivity extends AppCompatActivity implements CoursesListView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);
        new CoursesDownloader().execute();

    }

    @Override
    public void show(List<Course> courses) {
        final StringBuilder message  = new StringBuilder();
        for (Course course : courses) {
            message.append(course.getTitle() + "\n");
        }
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(), message.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private class CoursesDownloader extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            RestRepository retriever = new RestRepository();
            ShowCourses showCourses = new ShowCourses(retriever, CoursesListActivity.this);
            showCourses.showCourses();
            return null;
        }
    }
}
