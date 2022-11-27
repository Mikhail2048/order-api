package ru.zig.orderapi.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.zig.orderapi.database.entity.Order;
import ru.zig.orderapi.database.entity.Product;
import ru.zig.orderapi.database.entity.User;
import ru.zig.orderapi.database.repository.ProductRepository;
import ru.zig.orderapi.database.repository.UserRepository;
import ru.zig.orderapi.dto.OrderCreateDto;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderCreateMapper implements Mapper<OrderCreateDto, Order> {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public Order map(OrderCreateDto object) {
        Order order = new Order();
        copy(object, order);
        return order;
    }

    @Override
    public Order map(OrderCreateDto fromObject, Order toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(OrderCreateDto fromObject, Order toObject) {
        toObject.setUser(getUser(fromObject.getUserId()));
        toObject.setOrderStatus(fromObject.getOrderStatus());
        toObject.setArrivingLocation(fromObject.getArrivingLocation());
        toObject.setPayed(fromObject.isPayed());
        toObject.setProducts(getProducts(fromObject.getProducts()));
    }

    //Надо будет бросать exception, если пользовтеля не будет, иначе order будет некорректный
    private User getUser(Long userId) {
        return Optional.ofNullable(userId)
                .flatMap(userRepository::findById)
                .orElse(null);
    }

    private Set<Product> getProducts(Set<Long> productIds) {

        return Optional.ofNullable(productIds)
                .flatMap(productRepository::findAllById)
                .orElse(null);
    }

}

