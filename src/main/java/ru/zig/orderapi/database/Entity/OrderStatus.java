package ru.zig.orderapi.database.Entity;

/**
 * OrderStatus (REGISTERED, ASSIGNED, PACKED, ON_THE_WAY, WAITING_FOR_USER, DELIVERED)
 */

public enum OrderStatus {
    REGISTERED,
    ASSIGNED,
    PACKED,
    ON_THE_WAY,
    WAITING_FOR_USER,
    DELIVERED
}
