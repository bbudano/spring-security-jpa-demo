--liquibase formatted sql

--changeset bbudano:insert_roles
insert into roles (id, name) values (1, 'ROLE_ADMIN');
insert into roles (id, name) values (2, 'ROLE_USER');

--changeset bbudano:insert_users
insert into users (id, email, password, status)
values (1, 'admin@demo.hr', '$2a$10$OeqIRToiX1kNjs7jPnhLdOtjjFoaCrH6MH8rwsiAade3kIoW87f8C', 'ACTIVE');
insert into users (id, email, password, status)
values (2, 'user@demo.hr', '$2a$10$f8rJW2f4P81VZTSOCwyUsujTsT7qz97heRb3b1AAWhwjUxollaurW', 'ACTIVE');

--changeset bbudano:insert_users_roles
insert into users_roles (role_id, user_id)
values (1, 1);
insert into users_roles (role_id, user_id)
values (2, 1);
insert into users_roles (role_id, user_id)
values (2, 2);
