package org.example.repository;

import org.example.items.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repository {
    private static Repository instace = null;
    public static Repository getInstance(){
        if (instace == null){
            instace = new Repository();
            Collections.addAll(instace.items,
                    new Item(1,"Serega", 15),
                    new Item(2,"Lexa", 16),
                    new Item(3,"Vlad", 14),
                    new Item(4,"Max", 7)
            );
        }
        return instace;
    }
    private List<Item> items;

    public Repository(){
        items = new ArrayList<>();
    }
    public void addNew(Item item){
        items.add(item);
    }
    public List<Item> getAll(){
        return items;
    }
}