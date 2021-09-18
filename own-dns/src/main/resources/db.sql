

drop table if exists category cascade ;
create table category(
    category_id serial primary key,
    name varchar(50)
);



drop table if exists seller cascade ;
create table seller(
    seller_id serial primary key ,
    name varchar(50)
);



drop table if exists product cascade;
create table product(
    product_id serial primary key,
    article int,
    price int,
    available boolean default true,
    description varchar(100),
    seller_id int,
    category_id int,
    foreign key (category_id) references category(category_id),
    foreign key (seller_id)references seller(seller_id)
);


drop table if exists dns_user cascade ;
create table dns_user(
    dnsuser_id serial primary key,
    name varchar(50)
);


drop table if exists orders cascade ;
create table orders(
    order_id serial primary key,
    product_id int,
    dns_user_id int,
    amount int,
    foreign key (product_id) references product(product_id),
    foreign key (dns_user_id) references dns_user(dnsuser_id)
);



drop table if exists reviews cascade;
create table reviews(
    reviews_id serial primary key,
    text varchar(500),
    product_id int,
    foreign key (product_id) references product(product_id)
);