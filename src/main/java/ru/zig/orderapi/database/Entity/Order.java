package ru.zig.orderapi.database.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Order (orderId, userId, orderStatus, arrivingLocation, isPayed, List<Product>, createdAt)
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order extends AuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private String arrivingLocation;

    private boolean isPayed;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private List<Product> productsInOrder;

}
