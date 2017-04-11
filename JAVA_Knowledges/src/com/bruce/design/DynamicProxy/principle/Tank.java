package com.bruce.design.DynamicProxy.principle;

import java.util.Random;


public class Tank implements IShoot{

    @Override
    public void shoot() {
        System.out.println("Tank Shooting...");
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
