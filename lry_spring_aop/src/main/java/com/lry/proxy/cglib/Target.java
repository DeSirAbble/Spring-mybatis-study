package com.lry.proxy.cglib;

import com.lry.proxy.jdk.TargetInterface;

public class Target implements TargetInterface {

    public void save() {
        System.out.println("save running ...");
    }
}
