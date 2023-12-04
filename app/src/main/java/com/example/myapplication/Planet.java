package com.example.myapplication;

public class Planet {
    private String name;
    private String size;
    private String orbit;
    private String color;



    public String getSize() {
        return size;
    }

    public String getOrbit() {
        return orbit;
    }

    public String getColor() {
        return color;
    }

    public Planet(String name, String size, String orbit, String color) {
        this.name = name;
        this.size =size;
        this.orbit = orbit;
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setOrbit(String model) {
        this.orbit = orbit;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "com.example.myapplication.Planet{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", orbit='" + orbit + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
