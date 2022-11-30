--liquibase formatted sql

--changeset zig199:1
INSERT INTO users (user_status, is_active_buyer, address, bankcard_number, balance_bankcard)
VALUES ('ACTIVE', true, 'Moscow, St. Kulikova', 32123458583954, 45340);

INSERT INTO users (user_status, is_active_buyer, address, bankcard_number, balance_bankcard)
VALUES ('ACTIVE', true, 'Izhevsk, St. Kulikova', 42123458583999, 210);

INSERT INTO users (user_status, is_active_buyer, address, bankcard_number, balance_bankcard)
VALUES ('NOT_ACTIVE', true, 'Grozny, St. Kulikova', 58123458583043, 34320);

INSERT INTO users (user_status, is_active_buyer, address, bankcard_number, balance_bankcard)
VALUES ('NOT_ACTIVE', true, 'Glazov, St. Kulikova', 48123458583821, 150000);

INSERT INTO users (user_status, is_active_buyer, address, bankcard_number, balance_bankcard)
VALUES ('ACTIVE', true, 'Perm, St. Kulikova', 21123458583111, 0);