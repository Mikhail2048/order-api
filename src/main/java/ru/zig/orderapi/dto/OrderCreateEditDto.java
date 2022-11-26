package ru.zig.orderapi.dto;

import lombok.Value;
import lombok.experimental.FieldNameConstants;
import ru.zig.orderapi.database.entity.enums.OrderStatus;

import java.util.Set;

@Value
@FieldNameConstants
public class OrderCreateEditDto {

    Long userId;

    OrderStatus orderStatus;

    String arrivingLocation;

    Set<Long> products;
}


