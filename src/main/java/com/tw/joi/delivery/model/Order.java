package com.tw.joi.delivery.model;
import java.util.*;

public class Order {
    private String id;
    private Customer customer;
    private Store store;
    private Map<Item, Integer> items;
    private Double totalPrice;
    private OrderStatus status;
    private DeliveryPartner deliveryPartner;

    public Order(String id, Customer customer, Store store, Map<Item, Integer> items) {
        this.id = id;
        this.customer = customer;
        this.store = store;
        this.items = items;
        this.totalPrice = 0.0;
        this.status = OrderStatus.CREATED;
        this.deliveryPartner= null;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Store getStore() {
        return store;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public DeliveryPartner getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setDeliveryPartner(DeliveryPartner deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }
    
    

    


}
