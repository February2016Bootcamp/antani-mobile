package com.antani.mobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.antani.mobile.adapter.delivery.DatePresenter;
import com.antani.mobile.adapter.delivery.PricePresenter;
import com.antani.mobile.adapter.repository.RestRepository;
import com.antani.mobile.domain.entities.Course;
import com.antani.mobile.domain.interactors.Registration;
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
        courseList = (ListView) findViewById(R.id.course_list);
        courseList.setOnItemClickListener(listener);
        new CoursesDownloader().execute();
    }

    @Override
    public void show(final List<Course> courses) {
        final StringBuilder message = new StringBuilder();
        for (Course course : courses) {
            message.append(course.getTitle() + "\n");
        }
        runOnUiThread(new Runnable() {
            public void run() {
                courseList.setAdapter(new CoursesAdapter(CoursesListActivity.this, courses, new DatePresenter(), new PricePresenter()));
            }
        });
    }


    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            new PerformSubscription().execute("02");
        }
    };

    private class CoursesDownloader extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            RestRepository retriever = new RestRepository();
            ShowCourses showCourses = new ShowCourses(retriever, CoursesListActivity.this);
            showCourses.showCourses();
            return null;
        }
    }

    private class PerformSubscription extends AsyncTask<String, String, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            RestRepository repository = new RestRepository();
            Registration registration = new Registration(repository);
            return registration.subscribe(params[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            Toast.makeText(CoursesListActivity.this, aBoolean ? "success" : "failure", Toast.LENGTH_LONG).show();
        }
    }
}
