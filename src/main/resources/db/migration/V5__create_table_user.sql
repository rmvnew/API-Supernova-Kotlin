CREATE TABLE user(
    id int auto_increment primary key,
    name varchar(200) not null,
    register varchar(100) not null,
    email varchar(60) not null,
    password varchar(100) not null,
    profile varchar(150) not null,
    is_active BOOLEAN not null,
    create_at TIMESTAMP,
    update_at TIMESTAMP,
    address_id int not null,
    phone_id int not null,
    FOREIGN KEY (address_id) REFERENCES address(id),
    FOREIGN KEY (phone_id) REFERENCES phone(id)
);