-- Create admin user
CREATE ROLE demo_admin LOGIN
    PASSWORD 'demo_admin'
    SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;

-- Create db with admin owner
CREATE DATABASE demo
    WITH OWNER = demo_admin
    ENCODING = 'UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Create schema
\connect demo demo_admin;
CREATE SCHEMA spring_security_jpa;

-- Add created schema to search path
ALTER ROLE demo_admin IN DATABASE demo SET search_path = spring_security_jpa, public;
