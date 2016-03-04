package com.antani.mobile;


import com.antani.mobile.adapter.delivery.PricePresenter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PricePresenterTest {

    @Test
    public void price() throws Exception {
        PricePresenter pricePresenter = new PricePresenter();
        assertThat("111.13 €", is(pricePresenter.format(11113)));
    }

    @Test
    public void zero() throws Exception {
        PricePresenter pricePresenter = new PricePresenter();
        assertThat("GRATIS", is(pricePresenter.format(0)));
    }
}
