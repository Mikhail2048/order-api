package ru.zig.orderapi.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zig.orderapi.database.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
