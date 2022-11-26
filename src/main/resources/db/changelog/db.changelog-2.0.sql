--liquibase formatted sql


--changeset dmatveyenka:1
CREATE TABLE IF NOT EXISTS orders_product
(
    id BIGSERIAL PRIMARY KEY ,
    orders_id BIGINT NOT NULL REFERENCES orders (id) ON DELETE CASCADE ,
    product_id BIGINT NOT NULL REFERENCES product (id) ON DELETE CASCADE ,
    UNIQUE (orders_id, product_id)
);