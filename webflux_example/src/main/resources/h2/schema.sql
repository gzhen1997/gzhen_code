-- drop table if exists tb_user;
create table tb_user
(
    id          bigint auto_increment
        primary key,
    username    varchar(64) not null,
    name         varchar(64) not null,
    age int    null,
    balance decimal(10,2)
);