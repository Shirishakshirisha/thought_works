package com.tw.joi.delivery.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SampleProblemTest {

    @Test
    void shouldReturnTheBaseCostOfTheDelivery() {
        SampleProblem calculator = new SampleProblem();
        double cost = calculator.calculateCost(3.0);
        assertEquals(50.0, cost, "Cost should be ₹50 for up to 5 km");
    }

}