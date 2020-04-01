package com.example.sandbox.service;

import com.example.sandbox.factory.HubFactory;
import com.example.sandbox.model.Container;
import com.example.sandbox.model.ContainerType;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.BDDMockito.given;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DeliveryServiceTest {

    @InjectMocks
    private DeliveryService target;

    @Mock
    private ContainerService containerService;

    @Test
    public void shouldGetCollectionPointsForAnExpectedSize() {
        // GIVEN
        Set<Container> containers = getContainers();

        given(containerService.getContainers()).willReturn(containers);

        // WHEN
        Set<Container> result = target.getCollectionPoints(5);

        // THEN
        Assertions.assertThat(result).hasSize(6);
    }

    @Test
    public void shouldGetCollectionPointsForAnUnexpectedSize() {
        // GIVEN
        int size = 25;

        Set<Container> containers = getContainers();

        given(containerService.getContainers()).willReturn(containers);

        // WHEN
        Set<Container> result = target.getCollectionPoints(size);

        // THEN
        Assertions.assertThat(result).hasSize(3);
    }

    @Test
    public void shouldReserveHubForCustomer() {
        // GIVEN
        int size = 25;

        Set<Container> containers = getContainers();

        given(containerService.getContainers()).willReturn(containers);

        // WHEN
        Optional<Container> result = target.reserve(size);

        // THEN
        Assertions.assertThat(result.get().getType()).isEqualTo(ContainerType.HUB);
    }

    @Test
    public void shouldReserveLockerForCustomer() {
        // GIVEN
        int size = 5;
        Set<Container> containers = new HashSet<>();

        containers.add(new Container("Milano", ContainerType.LOCKER, true, 15));
        containers.add(new Container("Roma", ContainerType.LOCKER, true, 15));
        containers.add(new Container("Lecce", ContainerType.LOCKER, true, 15));

        given(containerService.getContainers()).willReturn(containers);

        // WHEN
        Set<Container> collectionPoints = target.getCollectionPoints(size);

        Assertions.assertThat(collectionPoints).hasSize(3);

        Optional<Container> result = target.reserve(size);

        Set<Container> collectionPointsMinusOneReserved = target.getCollectionPoints(size);


        // THEN
        Assertions.assertThat(result.get().getType()).isEqualTo(ContainerType.LOCKER);
        Assertions.assertThat(collectionPointsMinusOneReserved).hasSize(2);
    }

    private Set<Container> getContainers() {
        Set<Container> containers = new HashSet<>();

        containers.add(new Container("Hub1", ContainerType.HUB, true, 9999));
        containers.add(new Container("Hub2", ContainerType.HUB, true, 9999));
        containers.add(new Container("Hub3", ContainerType.HUB, true, 9999));
        containers.add(new Container("Milano", ContainerType.LOCKER, true, 15));
        containers.add(new Container("Roma", ContainerType.LOCKER, true, 15));
        containers.add(new Container("Lecce", ContainerType.LOCKER, true, 15));
        return containers;
    }
}
