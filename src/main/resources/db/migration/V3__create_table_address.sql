CREATE TABLE address (
    id int auto_increment primary key,
    zip_code varchar(45) not null,
    state varchar(45) not null,
    city varchar(100) not null,
    district varchar(100) not null,
    street varchar(100) not null,
    number varchar(100) not null,
    is_active BOOLEAN not null,
    create_at TIMESTAMP,
    update_at TIMESTAMP

);