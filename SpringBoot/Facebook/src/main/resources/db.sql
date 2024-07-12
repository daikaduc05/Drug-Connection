create database facebook_manager;
use facebook_manager;
create table role (
    id   int auto_increment primary key,
    name varchar(255) not null
);
insert into role (id, name)
values (1, 'ROLE_USER');

insert into user (id, birthday, email, from_to, gender, graduated, live_in, name, password, phone_number, quantity_friend, relationship_status, username, workplace)
values (1, '2005-01-12', 'admin@gmail.com', 'Viêt Nam', true, 'THPT Hoàng Hoa Thám', 'Đà Nẵng', 'Võ Huy Hoàng','admin', '0935271790', 100, 'Độc Thân', 'admin', 'tại nhà');
insert into user (id, birthday, email, from_to, gender, graduated, live_in, name, password, phone_number, quantity_friend, relationship_status, username, workplace)
values (2, '2004-02-13', 'guest@gmail.com', 'Viêt Nam', false, 'THPT Ngô Quyền', 'Đà Nẵng', 'Nguyễn Văn A','guest', '0933276390', 100, 'Độc Thân', 'guest', 'tại nhà');

insert into user_role (user_id, role_id)
values (1, 2);
insert into user_role (user_id, role_id)
values (2, 1);

insert into react (id, name, user_id)
values (1, 'tym', 1);



