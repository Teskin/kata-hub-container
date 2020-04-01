package com.example.sandbox.service;

import com.example.sandbox.factory.ContainerFactory;
import com.example.sandbox.factory.LockerFactory;
import com.example.sandbox.model.Container;

import java.util.HashSet;
import java.util.Set;

public class LockerService {

    private final ContainerFactory containerFactory;

    public LockerService(LockerFactory containerFactory) {
        this.containerFactory = containerFactory;
    }

    public Set<Container> getLockers() {
        Set<Container> lockers = new HashSet<>();

        lockers.add(containerFactory.create("Milano"));
        lockers.add(containerFactory.create("Roma"));
        lockers.add(containerFactory.create("Lecce"));

        return lockers;
    }
}
