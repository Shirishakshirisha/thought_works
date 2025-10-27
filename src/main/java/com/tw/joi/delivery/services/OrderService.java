package com.tw.joi.delivery.services;

import com.tw.joi.delivery.model.Order;
import com.tw.joi.delivery.model.OrderStatus;
import com.tw.joi.delivery.problems.SampleProblem;

public class OrderService {
    private final DistanceService distanceService;
    private final InventoryService inventoryService;

    public OrderService() {
        this.distanceService = new DistanceService();
        this.inventoryService = new InventoryService();
    }



    public Order processNewOrder(Order order, String customerZone) {
        // 1. Inventory Check
        if (!inventoryService.checkInventory(order.getStore(), order.getItems())) {
            order.setStatus(OrderStatus.REJECTED);
            System.out.println("Order " + order.getId() + " REJECTED: Store is missing requested items.");
            return order;
        }



        // 2. Price Calculation
        
        // A. Item Subtotal
        double subtotal = inventoryService.calculateItemsSubtotal(order.getItems());

        // B. Delivery Cost (Requires distance lookup and the SampleProblem logic)
        String storeZone = order.getStore().getZone();
        Integer distanceUnit = distanceService.getDistance(storeZone, customerZone);


        //We assume the distanceUnit maps directly to 'distanceKm' for SampleProblem.calculateCost
        // NOTE: calculateCost is a static method in SampleProblem
        double deliveryCost = SampleProblem.calculateCost(distanceUnit.doubleValue()); 

        // C. Final Total (Simplistic: Subtotal + Delivery Cost)
        // NOTE: We skip tax and loyalty discount as Customer model lacks a zone for delivery, 
        //       and loyalty points are stored as a String, making direct calculation complex.
        double finalCost = subtotal + deliveryCost;
        
        // 3. Update Order State
        order.setTotalPrice(finalCost);
        order.setStatus(OrderStatus.IN_PREPARATION); // Ready for preparation
        
        return order;
    }

}
