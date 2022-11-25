package ru.zig.orderapi.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zig.orderapi.database.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
