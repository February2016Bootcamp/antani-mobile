package com.antani.mobile.adapter.delivery;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePresenter {

    public String format(Date dateTime) {
        SimpleDateFormat readable = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dateStr = readable.format(dateTime);
        return dateStr;
    }
}
