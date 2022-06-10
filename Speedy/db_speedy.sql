create database db_speedy;

use db_speedy;

create table Mascota(
	idMascota int primary key auto_increment,
    nombreMascota varchar(50),
    edad int
);

insert into Mascota (nombreMascota, edad) values ("Belleza", 2);
insert into Mascota (nombreMascota, edad) values ("Steven", 3);

select * from Mascota