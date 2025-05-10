package com.example.shopfun;

public class Nut {
    private int imageResId;
    private String name;

    public Nut(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }
}
