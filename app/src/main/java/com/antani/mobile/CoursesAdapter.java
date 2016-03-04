package com.antani.mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.antani.mobile.adapter.delivery.DatePresenter;
import com.antani.mobile.adapter.delivery.PricePresenter;
import com.antani.mobile.domain.entities.Course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CoursesAdapter extends BaseAdapter {

    private Context context;
    private final List<Course> courses;
    private DatePresenter datePresenter;
    private PricePresenter pricePresenter;

    public CoursesAdapter(Context context, List<Course> courses, DatePresenter datePresenter, PricePresenter pricePresenter){
        this.context = context;
        this.courses = courses;
        this.datePresenter = datePresenter;
        this.pricePresenter = pricePresenter;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Object getItem(int position) {
        return courses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Course course = (Course) getItem(position);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate(R.layout.course_item, null);
        }
        TextView title = (TextView)convertView.findViewById(R.id.course_title);
        title.setText(course.getTitle());

        TextView price = (TextView)convertView.findViewById(R.id.course_price);
        price.setText(pricePresenter.format(course.getPrice()));

        TextView date = (TextView)convertView.findViewById(R.id.course_date);
        date.setText(datePresenter.format(getDate(course)));

        return convertView;
    }

    private Date getDate(Course course) {
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = Calendar.getInstance().getTime();
        try {
            date = sfd.parse(course.getDateTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
