package com.tw.joi.delivery.problems;

public class AssignNearestStore {
    public static void main(String[] args) {
        double[] itemPrices = {100.0, 250.0, 150.0};
        int[] quantities = {1, 2, 1};

        //  Calculate the assigned Store and its distance
        Object storeDetails = doSomething(itemPrices, quantities);

        // Print results
        System.out.println("Assigned Store: ₹" + storeDetails);
        System.out.println("Distance: ₹" + storeDetails);
    }

    // Write your methods here.
    public static Object doSomething(double[] itemPrices, int[] quantities) {
        return null;
    }
}
