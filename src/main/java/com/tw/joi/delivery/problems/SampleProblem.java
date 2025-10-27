package com.tw.joi.delivery.problems;
import java.util.*;

import com.tw.joi.delivery.model.Customer;
import com.tw.joi.delivery.model.Item;
import com.tw.joi.delivery.model.Order;
import com.tw.joi.delivery.model.Store;
import com.tw.joi.delivery.services.OrderService;
import com.tw.joi.delivery.staticData.StaticData;

public class SampleProblem {
    public static void main(String[] args) {
        System.out.println();
        SampleProblem sample = new SampleProblem();
        double cost = sample.calculateCost(8.0); // Example distance
        System.out.println("Delivery cost for 8 km: ₹" + cost);

        // **********************************************************************************
        Customer testCustomer = new Customer("C101","Alice","Smith");
        String customerZone = "ZoneC";

        Store store1 = StaticData.stores.get(0);

        List<Item> staticItems = StaticData.items;

        Item notebook = staticItems.stream().filter(i -> i.getName().equals("Notebook")).findFirst().get();
        Item mouse = staticItems.stream().filter(i -> i.getName().equals("Mouse")).findFirst().get();

        Map<Item, Integer> requestedItems = new HashMap<>();
        requestedItems.put(notebook,2);
        requestedItems.put(mouse,1);




        Store store4 = new Store("4", "ZoneA", Arrays.asList("Notebook", "Mouse"));




        Order newOrder = new Order("0202501",testCustomer,store4,requestedItems);
        System.out.println("----New Order Created----");
        System.out.println("Initial Status : " + newOrder.getStatus());



        OrderService orderService = new OrderService();
        Order processedOrder = orderService.processNewOrder(newOrder, customerZone);

        

        // 4. Verification and Output
        System.out.println("\n--- ORDER PROCESSED ---");
        System.out.println("Customer: " + processedOrder.getCustomer().getFirstName());
        System.out.println("Store: " + processedOrder.getStore().getStoreId() + " (" + processedOrder.getStore().getZone() + ")");
        System.out.println("Final Status: " + processedOrder.getStatus());
        System.out.println("Total Cost: ₹" + String.format("%.2f", processedOrder.getTotalPrice()));
        
        // Expected Logic Check:
        // Distance (ZoneA to ZoneC) = 6 units
        // Delivery Cost: 50 (base) + (6-5)*10 = ₹60.0
        // Item Subtotal: (2 * Notebook@15) + (1 * Mouse@25) = 30 + 25 = ₹55.0
        // Total Cost (approx.): 55.0 + 60.0 = ₹115.0

        // **********************************************************************************
    }

    // Write your methods here.
    public static Double calculateCost(double distanceKm) {
        if (distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }

        double baseCost = 50.0;
        if (distanceKm <= 5) {
            return baseCost;
        } else {
            double extraDistance = distanceKm - 5;
            return baseCost + (extraDistance * 10);
        }
    }
}




























































// git init 
// git remote remove origin
// git remote add origin https://----
// git add .
// git commit -m "Initial commit"
// git push -u origin main
