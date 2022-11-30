package ru.zig.orderapi.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zig.orderapi.database.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
