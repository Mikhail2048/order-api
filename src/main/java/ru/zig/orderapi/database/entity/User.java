package ru.zig.orderapi.database.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.zig.orderapi.database.entity.enums.UserStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *  User (userId, userStatus, isActiveBuyer, allOrders, registeredDate, address, bankAccountInfo)
 *
 *  Я тут добавил от себя ещё поле всех отзывов пользователя
 */

//todo разберись где надо equals and hashCode исключить для полей
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
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

        //Удалять все отзывы, если удалён пользователь
        @Builder.Default
        @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
        private List<Feedback> userFeedbacks = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return isActiveBuyer == user.isActiveBuyer && id.equals(user.id) && userStatus == user.userStatus && Objects.equals(address, user.address) && Objects.equals(bankAccountInfo, user.bankAccountInfo);
    }

    @Override
        public int hashCode() {
            return Objects.hash(id, userStatus, address, bankAccountInfo);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", userStatus=" + userStatus +
                    ", isActiveBuyer=" + isActiveBuyer +
                    ", address='" + address + '\'' +
                    ", bankAccountInfo=" + bankAccountInfo +
                    '}';
        }
}
