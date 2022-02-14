CREATE TABLE category(
    id int auto_increment primary key,
    name varchar(200) not null,
    is_active BOOLEAN not null,
    create_at TIMESTAMP,
    update_at TIMESTAMP

);
