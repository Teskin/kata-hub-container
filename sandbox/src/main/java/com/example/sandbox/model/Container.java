package com.example.sandbox.model;

public class Container {

    private String name;
    private ContainerType type;
    private boolean isAvailable;
    private int sizeLimit;

    public Container(String name, ContainerType type, boolean isAvailable, int sizeLimit) {
        this.name = name;
        this.type = type;
        this.isAvailable = isAvailable;
        this.sizeLimit = sizeLimit;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getSizeLimit() {
        return sizeLimit;
    }
}
