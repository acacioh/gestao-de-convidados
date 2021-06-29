DROP TABLE IF EXISTS guest;

CREATE TABLE guest (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

insert into guest (name)
values ('João Silva');