package ru.zig.orderapi.database.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.zig.orderapi.database.entity.enums.OrderStatus;

import java.util.List;

/**
 * Order (orderId, userId, orderStatus, arrivingLocation, isPayed, List<Product>, createdAt)
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
//TODO настроить аудит энверс
public class Order extends AuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_orders_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_users_id")
    private User userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "arriving_location")
    private String arrivingLocation;

    @Column(name = "is_payed")
    private boolean isPayed;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "pk_product_id")
    private List<Product> products;

}
