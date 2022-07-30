package com.mzitow.foodsandcosmeticjungle.model;


import com.mzitow.foodsandcosmeticjungle.R;

public class CustomModel {

    int id;
    String name;

    int icon;

    public CustomModel(String name) {
        this.name = name;
        this.icon = R.drawable.ic_launcher_foreground;
    }

    public CustomModel(int id, String name) {
        this.id = id;
        this.name = name;
        this.icon = R.drawable.ic_launcher_foreground;
    }

    public CustomModel(int id, String name, int icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
