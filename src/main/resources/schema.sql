DROP TABLE IF EXISTS TB_MEMBER;
DROP TABLE IF EXISTS TB_MEMBER_LOGIN_HST;
DROP TABLE IF EXISTS TB_WISHLIST;
DROP TABLE IF EXISTS TB_WISH_PRODUCT;

create table TB_MEMBER
(
    email varchar(255),
    password varchar(255),
    name varchar(255),
    birth varchar(8),
    gender varchar(1),
    reg_dt timestamp,
    up_dt timestamp,
    primary key (email)
);

create table TB_MEMBER_LOGIN_HST
(
    email varchar(255),
    reg_dt timestamp,
    primary key (email)
);


create table TB_WISHLIST
(
    wishlist_seq bigint auto_increment,
    name varchar(255),
    list_img varchar(255),
    email varchar(255),
    reg_dt timestamp,
    up_dt timestamp,
    primary key (wishlist_seq)
);

create table TB_WISH_PRODUCT
(
    wishlist_seq bigint,
    prod_cd varchar(255),
    prod_nm varchar(255),
    prod_img varchar(255),
    reg_dt timestamp,
    up_dt timestamp,
    primary key (wishlist_seq, prod_cd)
);