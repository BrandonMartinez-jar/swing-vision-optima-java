create database proyect;

use proyect;

create table personaldata(
    Cedula int not null primary key,
    Nombre varchar(255) not null,
    FNacimiento  varchar(255) not null,
    Edad  varchar(255) not null,
    Sexo  varchar(255) not null,
    Ciudad  varchar(255) not null,
    Telefono  varchar(255) not null,,
    Ocupacion  varchar(255) not null,
    Email  varchar(255) not null,
    Hobbies  varchar(255) not null,
    Eps  varchar(255) not null
);

create table hclinica(
    Cedula int not null primary key,
    HOP varchar(255) not null,
    HCP varchar(255) not null,
    HOF varchar(255) not null,
    HCF varchar(255) not null,
    Patologias varchar(255) not null,
    Medicacion varchar(255) not null
);

alter table hclinica 
ADD FOREIGN KEY (Cedula) REFERENCES personaldata(Cedula);

create table citas(
    idCita int auto_increment primary key,
    Nombre varchar(255) not null,
    Cedula varchar(255) not null,
    Fecha varchar(255) not null,
    Hora varchar(255) not null
);

alter table citas 
ADD FOREIGN KEY (Cedula) REFERENCES personaldata(Cedula);
