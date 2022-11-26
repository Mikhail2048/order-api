--liquibase formatted sql

--changeset zig199:1
ALTER TABLE orders
    ADD COLUMN fk_users_id BIGINT REFERENCES users (pk_users_id);

