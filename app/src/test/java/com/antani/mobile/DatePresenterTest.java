package com.antani.mobile;

import com.antani.mobile.adapter.delivery.DatePresenter;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class DatePresenterTest
{
    @Test
    public void formatDate() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.MAY, 12, 11, 35, 02);
        DatePresenter datePresenter = new DatePresenter();
        Assert.assertThat("12/05/2016 11:35", CoreMatchers.is(datePresenter.format(calendar.getTime())));
    }
}
