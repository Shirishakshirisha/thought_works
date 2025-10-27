package com.tw.joi.delivery.services;
import java.util.*;

import com.tw.joi.delivery.model.Item;
import com.tw.joi.delivery.model.Store;
import com.tw.joi.delivery.staticData.StaticData;

public class InventoryService {
    private final List<Item> globalItems;

    public InventoryService(){
        this.globalItems = StaticData.items;
    }


    public boolean checkInventory(Store store, Map<Item, Integer> requestedItems){
        List<String> storeInventoryNames = store.getItems();
        

        for(Item item : requestedItems.keySet()){
            String itemName = item.getName();

            if(!storeInventoryNames.contains(itemName)){
                return false;
            }
        }
        return true;
    }


    public double calculateItemsSubtotal(Map<Item, Integer> requestedItems){
        double subTotal = 0.0;
        for(Map.Entry<Item, Integer> entry : requestedItems.entrySet()){
            Item item = entry.getKey();
            Integer quantity = entry.getValue();
            subTotal += item.getPrice() * quantity;
        }
        return subTotal;
    }
}
