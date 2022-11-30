--liquibase formatted sql

--changeset zig199:1
INSERT INTO feedback (text_of_feedback, users_id, product_id)
VALUES ('Отзыв пользователя', 4, 2);

INSERT INTO feedback (text_of_feedback, users_id, product_id)
VALUES ('Раньше был этот авто, он просто космос', 1, 1);