package ru.zig.orderapi.database.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 *  User (userId, userStatus, isActiveBuyer, allOrders, registeredDate, address, bankAccountInfo)
 *
 *  Я тут добавил от себя ещё поле всех отзывов пользователя
 */

//todo разберись где надо equals and hashCode исключить для полей
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends AuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private boolean isActiveBuyer;

    @OneToMany(mappedBy = "userId")
    private List<Order> allOrders = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Feedback> allFeedback = new ArrayList<>();
}
