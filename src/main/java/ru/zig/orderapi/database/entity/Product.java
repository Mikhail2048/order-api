package ru.zig.orderapi.database.entity;

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
//TODO настроить аудит энверс
public class Product extends AuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_product_id")
    private Long id;

    @Column(name = "name_product")
    private String nameProduct;

    //TODO за место historyOfPrice сделал price. Уточнить корректно ли это при условии,
    // что для записи истории цен буду использовать Hibernate Envers
    @Column(name = "price")
    private Long price;

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "description")
    private String description;

    //TODO Уточнить корректно ли будет не хранить картинку в БД, а просто ссылку к нему
    @Column(name = "images")
    private String urlToImage;

    @OneToMany(mappedBy = "productId")
    private List<Feedback> allFeedbacksOfUser;
}
