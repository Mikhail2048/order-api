package ru.zig.orderapi.database.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.zig.orderapi.database.entity.enums.OrderStatus;

import java.util.HashSet;
import java.util.Set;

/**
 * Order (orderId, userId, orderStatus, arrivingLocation, isPayed, List<Product>, createdAt)
 */

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
//TODO настроить аудит энверс
public class Order extends AuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "arriving_location")
    private String arrivingLocation;

    @Column(name = "is_payed")
    private boolean isPayed;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "orders_product",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

}
