package com.example.sandbox.service;

import com.example.sandbox.factory.ContainerFactory;
import com.example.sandbox.factory.HubFactory;
import com.example.sandbox.model.Container;

import java.util.HashSet;
import java.util.Set;

public class HubService {

    private final ContainerFactory containerFactory;

    public HubService(HubFactory containerFactory) {
        this.containerFactory = containerFactory;
    }

    public Set<Container> getHubs() {
        Set<Container> hubs = new HashSet<>();

        hubs.add(containerFactory.create("Hub1"));
        hubs.add(containerFactory.create("Hub2"));
        hubs.add(containerFactory.create("Hub3"));

        return hubs;
    }
}
