# # Creamos Usuarios
# INSERT INTO biblioteca.user (`id`,`address`, `age`, `dni`, `email`, `lastname`, `max_book`, `name`, `password`, `phone`)
# VALUES (0,'Av. Cabildo 123', 23, 234563212, 'jose@mail.com', 'Perez', 2, 'Jose', 'jose123', 11436985);
# INSERT INTO biblioteca.user (`id`,`address`, `age`, `dni`, `email`, `lastname`, `max_book`, `name`, `password`, `phone`)
# VALUES (1,'Av. Siempreviva 456', 45, 11468963, 'hsimpson@mail.com', 'Simpson', 2, 'Homero', 'homero123', 117258963);
# INSERT INTO biblioteca.user (`id`,`address`, `age`, `dni`, `email`, `lastname`, `max_book`, `name`, `password`, `phone`)
# VALUES (2,'Calle False 123', 36, 11468964, 'lmessi@mail.com', 'Messi', 3, 'Lionel', 'messi123', 11257436);
#
# # Creamos Admins
# INSERT INTO biblioteca.admin (`id`, `dni`, `email`, `lastname`, `name`, `password`, `phone`)
# VALUES ('0', '33442211', 'matiscava@mail.com', 'Scavarelli', 'Matias', 'mati123', '1122334455');
# INSERT INTO biblioteca.admin (`id`, `dni`, `email`, `lastname`, `name`, `password`, `phone`)
# VALUES ('1', '15247896', 'admin@mail.com', 'Scaloni', 'Lionel', 'scaloneta', '1169874532');
#
# # Creamos Titulos
#
# INSERT INTO biblioteca.title (`id`, `title`) VALUES ('1', 'La Divina Comedia');
# INSERT INTO biblioteca.title (`id`, `title`) VALUES ('2', 'IT');
# INSERT INTO biblioteca.title (`id`, `title`) VALUES ('3', 'Harry Potter y la piedra filosofal');
#
# # Creamos Autores
#
# INSERT INTO biblioteca.author (`id`, `born_date`, `death_date`, `info`, `lastname`, `name`)
# VALUES ('1', '1265-01-01', '1321-09-14', 'Dante Alighieri, bautizado Durante di Alighiero degli Alighieri, fue un poeta y escritor italiano, conocido por escribir la Divina comedia', 'Alighieri', 'Dante');
# INSERT INTO biblioteca.author (`id`, `born_date`, `death_date`, `info`, `lastname`, `name`)
# VALUES ('2', '1947-09-21', null, 'Escritor estadounidense. Se ganó el favor de la crítica con su primera novela, Carrie (1974).', 'King', 'Stephen');
# INSERT INTO biblioteca.author (`id`, `born_date`, `death_date`, `info`, `lastname`, `name`)
# VALUES ('3', '1965-07-31', null, 'Joanne Rowling (Yate, 31 de julio de 1965), quien escribe bajo los seudónimos de J. K. Rowling y Robert Galbraith, es una escritora, productora de cine y guionista británica, conocida por ser la autora de la serie de libros Harry Potter.', 'Rowling', 'J.K.');
#
# # Linkiando titulos
#
# INSERT INTO `biblioteca`.`linked_title` (`author_id`, `title_id`) VALUES ('1', '1');
# INSERT INTO `biblioteca`.`linked_title` (`author_id`, `title_id`) VALUES ('2', '2');
# INSERT INTO `biblioteca`.`linked_title` (`author_id`, `title_id`) VALUES ('3', '3');
#
# # Creamos Libros
#
# INSERT INTO biblioteca.book (`id`, `edition`, `editorial`, `enabled`, `year`, `ticket_id`, `title_id`)
# VALUES ('1', 4, 'Terramar', TRUE, 2010, null, 1);
# INSERT INTO biblioteca.book (`id`, `edition`, `editorial`, `enabled`, `year`, `ticket_id`, `title_id`)
# VALUES ('2', 2, 'ABADA', TRUE, 2021, null, 1);
# INSERT INTO biblioteca.book (`id`, `edition`, `editorial`, `enabled`, `year`, `ticket_id`, `title_id`)
# VALUES ('3', 9, 'Salamandra', TRUE, 2016, null, 3);
# INSERT INTO biblioteca.book (`id`, `edition`, `editorial`, `enabled`, `year`, `ticket_id`, `title_id`)
# VALUES ('4', 2, 'Debolsillo', TRUE, 2017, null, 2);
# INSERT INTO biblioteca.book (`id`, `edition`, `editorial`, `enabled`, `year`, `ticket_id`, `title_id`)
# VALUES ('5', 3, 'Debolsillo', TRUE, 2018, null, 2);
#



