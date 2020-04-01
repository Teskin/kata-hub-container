package com.example.sandbox.factory;

import com.example.sandbox.model.Container;
import com.example.sandbox.model.ContainerType;

public class LockerFactory implements ContainerFactory {

    private final int sizeLimit = 15;

    @Override
    public Container create(String name) {
        return new Container(name, ContainerType.LOCKER, true, sizeLimit);
    }
}
