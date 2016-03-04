package com.antani.mobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.antani.mobile.adapter.delivery.DatePresenter;
import com.antani.mobile.adapter.delivery.PricePresenter;
import com.antani.mobile.adapter.repository.RestRepository;
import com.antani.mobile.domain.entities.Course;
import com.antani.mobile.domain.views.CoursesListView;
import com.antani.mobile.domain.interactors.ShowCourses;

import java.util.List;

public class CoursesListActivity extends AppCompatActivity implements CoursesListView {

    private ListView courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);
        setTitle("Lista Corsi");
        courseList = (ListView)findViewById(R.id.course_list);

        new CoursesDownloader().execute();
    }

    @Override
    public void show(final List<Course> courses) {
        final StringBuilder message  = new StringBuilder();
        for (Course course : courses) {
            message.append(course.getTitle() + "\n");
        }
        runOnUiThread(new Runnable() {
            public void run() {
                courseList.setAdapter(new CoursesAdapter(CoursesListActivity.this, courses, new DatePresenter(), new PricePresenter()));
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
