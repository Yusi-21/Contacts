package com.example.shopfun;

public class Vegetable {
    private int imageResId;
    private String name;

    private Class<?> targetActivity;

    public Vegetable(int imageResId, String name, Class<?> targetActivity) {
        this.imageResId = imageResId;
        this.name = name;
        this.targetActivity = targetActivity;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public Class<?> getTargetActivity() {
        return targetActivity;
    }
}