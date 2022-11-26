package ru.zig.orderapi.database.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.zig.orderapi.database.entity.enums.OrderStatus;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts = new ArrayList<>();

}
