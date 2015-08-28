package com.bruce.java.onduty;

/**
 * Created by qizhenghao on 15-8-27.
 */
public class User {

    public User(int id, int group, String name, int gender) {
        this.id = id;
        this.group = group;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        String str = "";
        str = group+"组, " + name + ", " + (gender==1?"男":"女") + ", " + time + "次    ";
        return str;
    }

    String name;

    int id;

    int group;

    int gender;

    int time;
}
