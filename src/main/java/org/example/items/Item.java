package org.example.items;

public class Item {
    private int id;
    private String name;
    private int age;

    public Item(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }
}