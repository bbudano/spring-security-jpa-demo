--liquibase formatted sql

--changeset generated:baseline_schema
create sequence spring_security_jpa.users_id_seq start 10 increment 10;

    create table spring_security_jpa.users (
       id int8 not null,
        email varchar(255) not null,
        password varchar(255) not null,
        role varchar(255) not null,
        status varchar(255) not null,
        primary key (id)
    );

    alter table if exists spring_security_jpa.users
       add constraint user_email_unique unique (email);
