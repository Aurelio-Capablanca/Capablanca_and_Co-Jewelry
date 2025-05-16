Create database DB_Joyas 
use DB_Joyas 

create table Clasificacion (
codigoCla int Primary key not null,
nomClasif varchar(55) not null 
)

create table Piedra (
codigoPiedra int Primary key not null,
nomPiedra varchar(25) not null,
color varchar(25) not null,
joyeria varchar(25) not null,
codigoCla int not null references Clasificacion(codigoCla)
)

-----------------------inserciones --------------------------------


insert into Clasificacion values 
(1,'Roca'),
(2,'Mineral'),
(3,'Vidrio'),
(4,'Volcanica')


insert into Clasificacion values (5,'Marina')
---------------- Consultas -------------------


SELECT nomClasif FROM Clasificacion

SELECT nomClasif FROM Clasificacion tc, Piedra cl WHERE tc.codigoCla = cl.codigoCla AND cl.codigoPiedra = ?

SELECT codigoCla FROM Clasificacion WHERE nomClasif = ?

INSERT INTO Piedra(codigoPiedra,nomPiedra,color,joyeria,codigoCla) values 
(1,'Amatista','purpura','collar',1)

SELECT Max(codigoPiedra) FROM Piedra  

UPDATE Piedra SET nomPiedra=?, color=?, joyeria=?, telefono=?,codigoCla=? WHERE codigoPiedra=?

Select codigoPiedra, nomPiedra, color, joyeria, nomClasif  
From Piedra pr , Clasificacion cl Where pr.codigoCla=cl.codigoCla
and cl.codigoCla=2


SELECT nomClasif FROM Clasificacion tc, Piedra cl WHERE tc.codigoCla = cl.codigoCla AND cl.codigoPiedra = 1

SELECT codigoCla FROM Clasificacion WHERE nomClasif = 'Roca'