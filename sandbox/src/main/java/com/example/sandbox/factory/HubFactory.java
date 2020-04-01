package com.example.sandbox.factory;

import com.example.sandbox.model.Container;
import com.example.sandbox.model.ContainerType;

public class HubFactory implements ContainerFactory {

    @Override
    public Container create(String name) {
        return new Container(name, ContainerType.HUB, true, 9999);
    }
}
