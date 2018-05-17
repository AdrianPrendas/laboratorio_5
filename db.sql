spool db.log
conn system/root;

set LINESIZE 32000;
set PAGESIZE 40000;
set LONG 50000;

DROP TABLE carritos cascade constraint;
DROP TABLE productos cascade constraint;
DROP TABLE usuarios cascade constraint;

CREATE TABLE productos(
	id int,
	nombre varchar(30),
	imageUri varchar(30),
	precio float,
	cantidad int,
	CONSTRAINT pkproductos PRIMARY KEY(id)
);

CREATE TABLE usuarios(
	id int,
	nombre varchar(30),
	imageUri varchar(30),
	email varchar(30),
	password varchar(30),
	tipo int,
	CONSTRAINT pkusuarios PRIMARY KEY(id)
);

CREATE TABLE carritos(
	usuario int,
	producto int,
	CONSTRAINT pkcarritos PRIMARY KEY(usuario, producto),
	CONSTRAINT fkcarritos1 FOREIGN KEY (usuario) REFERENCES usuarios(id),
	CONSTRAINT fkcarritos2 FOREIGN KEY (producto) REFERENCES productos(id)
);

--PROCEDIMIENTO PARA INSERTAR PRODUCTOS
create or replace procedure insertarProductos(PId in int, PNombre in varchar, PImage in varchar2,
PPrecio in float, PCantidad in int) is
begin
insert into productos(id,nombre,imageUri,precio,cantidad) 
values (PId,PNombre,PImage,PPrecio,PCantidad); 
commit;
end insertarProductos;
/
show error

--PROCEDIMIENTO PARA MODIFICAR PRODUCTOS
create or replace procedure modificarProductos(PId in int, PNombre in varchar, PImage in varchar2,
PPrecio in float, PCantidad in int) is
begin 
update productos
set id=PId, nombre=PNombre,imageUri=PImage,
precio=PPrecio, cantidad=PCantidad
where id=PId;
END modificarProductos;
/
show error

--PROCEDIMIENTO PARA ELIMIAR PRODUCTOS
create or replace procedure eliminarProductos(PId in int) is
begin 
delete 
from productos
where id=PId;
end eliminarProductos;
/
show error 

--PROCEDIMIENTO PARA INSERTAR USUARIOS
create or replace procedure insertarUsuarios(PId in int, PNombre in varchar, PImage in varchar,
PEmail in varchar, PPassword in varchar, PTipo in int) is
begin
insert into usuarios(id,nombre,imageUri,email,password,tipo)
values(PId,PNombre,PImage,PEmail,PPassword,PTipo);
commit;
end insertarUsuarios;
/
show error 

--PROCEDIMIENTO PARA MODIFICAR USUARIOS
create or replace procedure modificarUsuarios(PId in int, PNombre in varchar, PImage in varchar,
PEmail in varchar, PPassword in varchar, PTipo in int) is
begin 
update usuarios
set id=PId, nombre=PNombre, imageUri=PImage,
email=PEmail, password=PPassword,tipo=PTipo
where id=PId;
commit;
end modificarUsuarios;
/
show error

--PROCEDIMIENTO PARA ELIMIAR USUARIOS
create or replace procedure eliminarUsuarios(PId in int) is
begin 
delete 
from usuarios
where id=PId;
end eliminarUsuarios;
/
show error

--PROCEDIMIENTO PARA INSERTAR CARRITOS
create or replace procedure insertarCarrito(PUsuario in int, PProducto in int) is
begin
insert into carritos(usuario,producto)
values (PUsuario,PProducto);
commit;
end;
/
show error

--PROCEDIMIENTO PARA MODIFICAR CARRITOS
create or replace procedure modificarCarrito(PUsuario in int, PProducto in int) is
begin
update carritos
set usuario=PUsuario, producto=PProducto
where usuario=PUsuario;
end modificarCarrito;
/
show error

--INSERTANDO USUARIOS
exec insertarUsuarios('813156487','Angel Yvanes Gerardo','','angel.yvanes.gerardo@una.ac.cr','angel',1);
exec insertarUsuarios('908069482','Carlos Asencio Ysidro','','carlos.asencio.ysidro@una.ac.cr','angel',1);
exec insertarUsuarios('118510669','Emiliano Sepulbeda Troche','','emiliano.sepulbeda.troche@una.ac.cr','angel',1);
exec insertarUsuarios('494658212','Santino Peredo Dongu','','santino.peredo.dongu@una.ac.cr','angel',1);
exec insertarUsuarios('673424513','Tomas Velasco Clemente','','tomas.velasco.clemente@una.ac.cr','angel',1);
exec insertarUsuarios('876415060','Benjamin Covos Brusiaga','','benjamin.covos.brusiaga@una.ac.cr','angel',1);
exec insertarUsuarios('984357664','Gael Mancilla Moia','','gael.mancilla.moia@una.ac.cr','angel',1);
exec insertarUsuarios('964465378','Emmanuel Canchola Espejo','','emmanuel.canchola.espejo@una.ac.cr','angel',1);
exec insertarUsuarios('769438762','Dylan Montecillo Balderas','','dylan.montecillo.balderas@una.ac.cr','angel',1);
exec insertarUsuarios('368377663','Emiliano Aguado Sifuentes','','emiliano.aguado.sifuentes@una.ac.cr','angel',1);
exec insertarUsuarios('304830405','Esteban Montero Fonseca','','esteban.montero.fonseca@est.una.ac.cr','angel',1);
exec insertarUsuarios('114830575','Kevin Calderon Rodriguez','','kevin.calderon.rodriguez@est.una.ac.cr','angel',1);
exec insertarUsuarios('604140420','Adrian prendas Araya','','adrian.prendas.araya@est.una.ac.cr','angel',1);
