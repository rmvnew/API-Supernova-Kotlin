CREATE TABLE product(
    id int auto_increment primary key,
    name varchar(200) not null,
    barcode varchar(100) not null,
    quantity INT not null,
    price decimal(10,2) not null,
    is_active BOOLEAN not null,
    create_at TIMESTAMP,
    update_at TIMESTAMP,
    category_id int not null,
    FOREIGN KEY (category_id) REFERENCES category(id)
);