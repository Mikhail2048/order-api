package ru.zig.orderapi.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Product (type, historyOfPrices, isAvailable, description, images, feedBacksOfUsers)
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//TODO настроить аудит энверс
public class Product extends AuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @Builder.Default
    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts = new ArrayList<>();

}
