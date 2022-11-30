package ru.zig.orderapi.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zig.orderapi.database.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
