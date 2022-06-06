-----------------------------------------USUARIOS-------------------------------------
INSERT INTO usuarios(nombre, apellidos, email, password) VALUES('Roman', 'Garcia', 'rga@gmail.com' , '$2a$10$gIjZ/MNu.T2hNd5UbsoTteVD4hUDMopwp1q0lruGMVGnALMqSr5se');
INSERT INTO usuarios(nombre, apellidos, email, password) VALUES('Paula', 'Rodriguez', 'pau@gmail.com' , '$2a$10$hDmghLvvZMXUXm4TR5pnm.DT.lI/GbhZ9BPx.o3DyYwhQXltyKH4G');

-----------------------------------------ROLES-------------------------------------
INSERT INTO roles(tipo) VALUES('Admin');
INSERT INTO roles(tipo) VALUES('User');

-----------------------------------------USUARIOS-ROLES-------------------------------------
INSERT INTO usuarios_roles(rol_id, usuario_id) VALUES (1, 1);
INSERT INTO usuarios_roles(rol_id, usuario_id) VALUES (2, 2);

-----------------------------------------ENTRADAS-------------------------------------
INSERT INTO entradas(titulo, texto) VALUES ("Entrada Uno", "Nuestra cocina sigue contando con alguno de nuestros platos clásicos muy demandados por nuestros clientes habituales y por nuevos sabores que incorporamos regularmente tratando de conjugar la cocina tradicional local con nuevas tendencias e ingredientes, sin perder de vista lo más importante: sabor y calidad.");
INSERT INTO entradas(titulo, texto) VALUES ("Entrada Dos", "Texto de entrada para el texto dos");


-----------------------------------------COMENTARIOS-------------------------------------
INSERT INTO comentarios(texto) VALUES ("comentario Uno");