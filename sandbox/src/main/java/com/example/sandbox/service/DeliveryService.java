package com.example.sandbox.service;

import com.example.sandbox.model.Container;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DeliveryService {

    private final ContainerService containerService;

    public DeliveryService(ContainerService containerService) {
        this.containerService = containerService;
    }

    public Set<Container> getCollectionPoints(int size) {
        return containerService
                .getContainers()
                .stream()
                .filter(Container::isAvailable)
                .filter(containerToFilter -> containerToFilter.getSizeLimit() >= size)
                .collect(Collectors.toSet());
    }

    public Optional<Container> reserve(int size) {
        Optional<Container> container = getCollectionPoints(size).stream().findFirst();

        container.ifPresent(containerFound -> containerFound.setAvailable(false));

        return container;
    }
}
