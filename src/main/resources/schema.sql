create table guest (
  id int auto_increment primary key,
  name varchar(250) not null
);

create table application_user (
  id int auto_increment primary key,
  username varchar(250) not null,
  password varchar(250) not null
);
