package ru.zig.orderapi.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.zig.orderapi.database.entity.Order;
import ru.zig.orderapi.database.entity.Product;
import ru.zig.orderapi.database.repository.ProductRepository;
import ru.zig.orderapi.dto.OrderReadBaseDto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderReadBaseMapper implements Mapper<Order, OrderReadBaseDto>{

    private final ProductRepository productRepository;
    @Override
    public OrderReadBaseDto map(Order object) {
        OrderReadBaseDto orderReadBaseDto = new OrderReadBaseDto();
        copy(object, orderReadBaseDto);
        return orderReadBaseDto;
    }

    @Override
    public OrderReadBaseDto map(Order fromObject, OrderReadBaseDto toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private OrderReadBaseDto copy(Order object, OrderReadBaseDto orderReadBaseDto) {
        orderReadBaseDto.setOrderStatus(object.getOrderStatus());
        orderReadBaseDto.setProducts(getProducts(object.getProducts()));
        orderReadBaseDto.setPayed(object.isPayed());
        return orderReadBaseDto;
    }

    private List<String> getProducts(Set<Product> products) {
        return productRepository.findAllById(
                products.stream()
                        .map(Product::getId)
                        .collect(Collectors.toSet()))
                .stream()
                .map(Product::getNameProduct)
                .collect(Collectors.toList());
    }


}
