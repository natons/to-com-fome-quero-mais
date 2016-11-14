CREATE DATABASE IF NOT EXISTS bdToComFome;

USE bdToComFome;

insert into EMPLOYEE values (1,"teste","joao","123");

insert into STOCK values (1, 20, 3);
insert into STOCK values (2, 5, 3);
insert into STOCK values (3, 10, 3);

insert into PRODUCT values(1, "lasanha", 10.0, 1);
insert into PRODUCT values(2, "vinho", 5.0, 2);
insert into PRODUCT values(3, "gelatina", 15.0, 3);

insert into DRINK (IDDRINK, IDPRODUCT_FK) values (2,2);

insert into DISH (IDDISH, IDPRODUCT_FK) values (1,1);

insert into DESSERT (IDDISSERT, IDPRODUCT_FK) values(3,3);