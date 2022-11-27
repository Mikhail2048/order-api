package ru.zig.orderapi.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

/**
 * Product (type, historyOfPrices, isAvailable, description, images, feedBacksOfUsers)
 */

@Getter
@Setter
//@EqualsAndHashCode(of = {"name"})
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
    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "product")
    private List<Feedback> productFeedbacks = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return isAvailable == product.isAvailable && id.equals(product.id) && Objects.equals(nameProduct, product.nameProduct) && Objects.equals(price, product.price) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProduct, price, isAvailable, description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", description='" + description + '\'' +
                '}';
    }
}
