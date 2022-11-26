package ru.zig.orderapi.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zig.orderapi.database.entity.enums.UserStatus;

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
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;

    @Column(name = "is_active_buyer")
    private boolean isActiveBuyer;

    @Column(name = "address")
    private String address;

    @Embedded
    @AttributeOverride(name = "bankcardNumber", column = @Column(name = "bankcard_number"))
    @AttributeOverride(name = "balanceBankcard", column = @Column(name = "balance_bankcard"))
    private BankAccountInfo bankAccountInfo;

}
