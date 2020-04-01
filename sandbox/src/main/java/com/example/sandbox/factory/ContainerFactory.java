package com.example.sandbox.factory;

import com.example.sandbox.model.Container;

public interface ContainerFactory {

    Container create(String name);
}
