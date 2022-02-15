CREATE TABLE phone (
    id int auto_increment primary key,
    phone varchar(45) not null,
    is_active BOOLEAN not null,
    create_at TIMESTAMP,
    update_at TIMESTAMP

);