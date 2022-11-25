package ru.zig.orderapi.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//TODO настроить аудит энверс
public class Feedback extends AuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_feedback_id")
    private Long id;

    @Column(name = "text_of_feedback")
    private String textOfFeedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pk_users_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pk_product_id")
    private Product productId;
}
