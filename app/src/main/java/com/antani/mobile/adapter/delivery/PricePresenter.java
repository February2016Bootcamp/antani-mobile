package com.antani.mobile.adapter.delivery;

public class PricePresenter {

    public String format(int price) {

        return price > 0 ? String.format("%.2f €", price / 100.0f) : "GRATIS";
    }
}
