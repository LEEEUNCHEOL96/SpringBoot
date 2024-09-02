package com.std.sbb;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int id;
    private int speed;
    private String name;
    private List<Integer> ids;

    Car(int id, int speed, String name, List<Integer> ids) {
        this.id = id;
        this.speed = speed;
        this.name =name;
        this.ids =ids;
    }

    public void setId(int id) {
        this.id=id;
    }

    public void setSpeed(int speed) {
        this.speed=speed;
    }

    public void setName(String name) {
        this.name= name;
    }

    public void setIds(ArrayList ids) {
        this.ids=ids;
    }

    public void getId() {
    }

    public void getSpeed() {
    }

    public void getName() {
    }

    public void getIds() {
    }
}
