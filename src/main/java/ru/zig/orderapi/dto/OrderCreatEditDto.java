package ru.zig.orderapi.dto;

import lombok.Value;
import lombok.experimental.FieldNameConstants;
import ru.zig.orderapi.database.entity.enums.OrderStatus;

@Value
@FieldNameConstants
public class OrderCreatEditDto {

    Long userId;

    OrderStatus orderStatus;

    String arrivingLocation;

    ProductReadBaseDto product;
}


