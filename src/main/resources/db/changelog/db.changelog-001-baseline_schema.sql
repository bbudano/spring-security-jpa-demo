--liquibase formatted sql

--changeset generated:baseline_schema
create sequence spring_security_jpa.roles_id_seq start 10 increment 10;
create sequence spring_security_jpa.users_id_seq start 10 increment 10;

    create table spring_security_jpa.roles (
       id int8 not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table spring_security_jpa.users (
       id int8 not null,
        email varchar(255) not null,
        password varchar(255) not null,
        status varchar(255) not null,
        primary key (id)
    );

    create table spring_security_jpa.users_roles (
       user_id int8 not null,
        role_id int8 not null
    );

    alter table if exists spring_security_jpa.roles
       add constraint role_name_unique unique (name);

    alter table if exists spring_security_jpa.users_roles
       add constraint FKj6m8fwv7oqv74fcehir1a9ffy
       foreign key (role_id)
       references spring_security_jpa.roles;

    alter table if exists spring_security_jpa.users_roles
       add constraint FK2o0jvgh89lemvvo17cbqvdxaa
       foreign key (user_id)
       references spring_security_jpa.users;
