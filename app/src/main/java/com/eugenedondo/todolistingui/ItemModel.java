package com.eugenedondo.todolistingui;

/**
 * Created by Eugene Dondo on 3/21/18.
 * Twitter: @eugeneDondo
 */

public class ItemModel {

    String name;
    String quantity;
    int color;
    boolean done;

    public ItemModel() {
    }

    public ItemModel(String name, String quantity, int color, boolean done) {
        this.name = name;
        this.quantity = quantity;
        this.color = color;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
