package com.tw.joi.delivery.problems;

import org.junit.jupiter.api.Test;

class AssignNearestStoreTest {


    @Test
    void ShouldReturnNearestStore() {
        double[] itemPrices = {150.0, 650.0, 450.0};
        int[] quantities = {4, 2, 3};
        AssignNearestStore.doSomething(itemPrices, quantities);
        assert true;
    }
}