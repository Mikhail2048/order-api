package ru.zig.orderapi.dto;

import lombok.Data;
import ru.zig.orderapi.database.entity.enums.OrderStatus;

import java.util.List;

@Data
public class OrderReadBaseDto {

    OrderStatus orderStatus;

    boolean isPayed;

    List<String> products;

}
