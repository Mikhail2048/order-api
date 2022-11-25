package ru.zig.orderapi.database.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Product (type, historyOfPrices, isAvailable, description, images, feedBacksOfUsers)
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Product extends AuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO за место historyOfPrice сделал price. Уточнить корректно ли это при условии,
    // что для записи истории цен буду использовать Hibernate Envers
    private Long price;

    private boolean isAvailable;

    private String description;

    //TODO Уточнить корректно ли будет не хранить картинку в БД, а просто ссылку к нему
    private String urlToImages;

    @OneToMany(mappedBy = "product")
    private List<Feedback> feedBacksOfUsers;
}
