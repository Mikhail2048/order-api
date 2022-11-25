--liquibase formatted sql

--changeset zig199:1
CREATE TABLE IF NOT EXISTS orders
(
    pk_orders_id BIGSERIAL PRIMARY KEY,
    order_status VARCHAR(32) NOT NULL,
    arriving_location TEXT,
    is_payed BOOLEAN NOT NULL,

    created_at TIMESTAMP,
    modified_at TIMESTAMP,
    created_by VARCHAR(32),
    modified_by VARCHAR(32)
);

--changeset zig199:2
CREATE TABLE IF NOT EXISTS users
(
    pk_users_id BIGSERIAL PRIMARY KEY,
    user_status VARCHAR(32),
    is_active_buyer BOOLEAN NOT NULL,
    address TEXT,
    bankcard_number BIGINT,
    balance_bankcard BIGINT,

    created_at TIMESTAMP,
    modified_at TIMESTAMP,
    created_by VARCHAR(32),
    modified_by VARCHAR(32)
);

--changeset zig199:3
CREATE TABLE IF NOT EXISTS product
(
    pk_product_id BIGSERIAL PRIMARY KEY,
    name_product VARCHAR(255),
    price INT,
    is_available BOOLEAN NOT NULL,
    description TEXT,
    images TEXT,

    created_at TIMESTAMP,
    modified_at TIMESTAMP,
    created_by VARCHAR(32),
    modified_by VARCHAR(32)

);

--changeset zig199:4
CREATE TABLE IF NOT EXISTS feedback
(
    pk_feedback_id BIGSERIAL PRIMARY KEY,
    text_of_feedback TEXT,
    fk_users_id BIGINT REFERENCES users (pk_users_id),
    fk_product_id BIGINT REFERENCES product (pk_product_id),

    created_at TIMESTAMP,
    modified_at TIMESTAMP,
    created_by VARCHAR(32),
    modified_by VARCHAR(32)
);
