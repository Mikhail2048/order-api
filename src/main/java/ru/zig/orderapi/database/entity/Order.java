package ru.zig.orderapi.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zig.orderapi.database.entity.enums.OrderStatus;

import java.util.List;

/**
 * Order (orderId, userId, orderStatus, arrivingLocation, isPayed, List<Product>, createdAt)
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//TODO настроить аудит энверс
public class Order extends AuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_oders_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pk_users_id")
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
    private List<Product> productsInOrder;

}
