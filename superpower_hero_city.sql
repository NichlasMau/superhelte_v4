CREATE DATABASE IF NOT EXISTS superpower_hero_city DEFAULT CHARACTER SET utf8;
USE superpower_hero_city;
DROP TABLE if exists superpower;
DROP TABLE if exists hero;
DROP TABLE IF exists city;
DROP TABLE IF exists city_superhero;
DROP TABLE IF exists superhero_superpower;

-- Opret database med 3 tables (superpower, city og Superhero)

create table superpower (
superpowerID integer not null primary key,
superpowerName varchar(50) not null
);

create table superhero (
superheroID INTEGER NOT NULL primary key,
heroName varchar (50) not null,
realName varchar(50) not null,
creationYear integer not null
);

create table city (
cityID Integer not null primary key,
cityName varchar(50) not null
);

create table superhero_SuperPower (
superheroID Integer not null,
superPowerID Integer not null,
primary key (superheroID, superPowerID),
foreign key (superheroID) references superhero(superheroID),
foreign key (superpowerID) references superpower(superpowerID)
);

create table city_superhero (
cityID Integer not null,
superheroID integer not null,
primary key (cityID, superheroID),
foreign key (cityID) references city(cityID),
foreign key (superheroID) references superhero(superheroID)
);

-- tilføj testdata

Insert into superpower (superpowerID,superpowerName) values (1, 'flyvning');
Insert into superpower (superpowerID,superpowerName) values (2, 'Usynlighed');
Insert into superpower (superpowerID,superpowerName) values (3, 'Superstyrke');

Insert into superHero (superheroID, heroName, realName, creationYear) values (1, 'Superman', 'Clark Kent', 1938);
Insert into superHero (superheroID, heroName, realName, creationYear) values (2, 'Batman', 'Brunce Wayne', 1939);
insert into superHero (superheroID, heroName, realName, creationYear) values (3, 'Spiderman', 'Peter Parker',1962);

Insert into city (cityID, cityName) Values (1, 'Metropolis');
Insert into city (cityID, cityName) Values (2, 'Gotham City');
Insert into city (cityID, cityName) Values (3, 'New York');

Insert into superhero_superpower (superheroID, superpowerID) Values (1, 1);
Insert into superhero_superpower (superheroID, superpowerID) Values (1, 3);
Insert into superhero_superpower (superheroID, superpowerID) Values (2, 2);
Insert into superhero_superpower (superheroID, superpowerID) Values (2, 3);
Insert into superhero_superpower (superheroID, superpowerID) Values (3, 1);
Insert into superhero_superpower (superheroID, superpowerID) Values (3, 3);

Insert into city_superhero (cityID, superheroID) Values (1, 1);
Insert into city_superhero (cityID, superheroID) Values (2, 2);
Insert into city_superhero (cityID, superheroID) Values (3, 3);
Insert into city_superhero (cityID, superheroID) Values (3, 2);










