package com.tw.joi.delivery.model;

public enum CustomerSegment {

    DIAMOND(10), GOLD(5), SILVER(3);

    private int value;

    CustomerSegment(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
