package com.example.shopfun;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private static Catalog instance;
    private List<String> selectedItems;

    private Catalog() {
        selectedItems = new ArrayList<>();
    }

    public static Catalog getInstance() {
        if (instance == null) {
            instance = new Catalog();
        }
        return instance;
    }

    public void addItem(String item) {
        if (!selectedItems.contains(item)) {
            selectedItems.add(item);
        }
    }

    public void removeItem(String item) {
        selectedItems.remove(item);
    }

    public List<String> getSelectedItems() {
        return selectedItems;
    }
}