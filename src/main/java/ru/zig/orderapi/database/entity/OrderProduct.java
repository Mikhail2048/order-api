package ru.zig.orderapi.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders_product")
public class OrderProduct implements BaseEntity<Long>{

    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

//TODO если тут какая-то шибка будет, то я возможно Long id пихнул в него неправильно так как он по сути
// должен сам генерится. В общем разберись с этим если что-то пойдёт не так
    public OrderProduct(Long id, Order order, Product product) {
        this.id = id;
        this.order = order;
        this.order.getOrderProducts().add(this);

        this.product = product;
        this.product.getOrderProducts().add(this);
    }


    /**
     *     Чтобы не вызывать самому сеттеры для соотвествия объектной и реляционной модели эти методы
     *     пихнул в AllArgsConstructor
     */

//    public void setOrder(Order order) {
//        this.order = order;
//        this.order.getOrderProducts().add(this);
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//        this.product.getOrderProducts().add(this);
//    }
}
