package com.example.sandbox.service;

import com.example.sandbox.model.Container;

import java.util.HashSet;
import java.util.Set;

public class ContainerService {

    private final HubService hubService;
    private final LockerService lockerService;

    public ContainerService(HubService hubService, LockerService lockerService) {
        this.hubService = hubService;
        this.lockerService = lockerService;
    }

    public Set<Container> getContainers() {
        Set<Container> containers = new HashSet<>();

        containers.addAll(hubService.getHubs());
        containers.addAll(lockerService.getLockers());

        return containers;

    }
}
