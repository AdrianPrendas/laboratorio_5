

DROP TABLE carritos cascade constraint;;
DROP TABLE productos cascade constraint;;
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