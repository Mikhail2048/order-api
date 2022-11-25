package ru.zig.orderapi.dto;

import lombok.Value;
import lombok.experimental.FieldNameConstants;

@Value
@FieldNameConstants
public class ProductReadBaseDto {

    Long id;

    String nameProduct;

    Long price;

}
