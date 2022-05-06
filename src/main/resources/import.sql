-----------------------------------------USUARIOS-------------------------------------
INSERT INTO usuarios(nombre, apellidos, email, password) VALUES('Roman', 'Garcia', 'rga@gmail.com' , '$2a$10$Qg1/AANZIJgdPp.TYxAaPehrNcv1Mtm/mwG57P3k5eZRxCvhsd5M2');
INSERT INTO usuarios(nombre, apellidos, email, password) VALUES('Paula', 'Rodriguez', 'pau@gmail.com' , '4321');

-----------------------------------------ROLES-------------------------------------
INSERT INTO roles(tipo) VALUES('Admin');
INSERT INTO roles(tipo) VALUES('User');

-----------------------------------------USUARIOS-ROLES-------------------------------------
INSERT INTO usuarios_roles(rol_id, usuario_id) VALUES (1, 1);
INSERT INTO usuarios_roles(rol_id, usuario_id) VALUES (2, 2);

-----------------------------------------ENTRADAS-------------------------------------
INSERT INTO entradas(titulo, texto) VALUES ("Entrada Uno", "Texto de entrada para el texto uno");

-----------------------------------------COMENTARIOS-------------------------------------
INSERT INTO comentarios(texto) VALUES ("comentario Uno");