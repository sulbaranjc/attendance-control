USE ilerna;

INSERT INTO  ilerna.fp (nombre, descripcion) 
VALUES 
	 ('DAM-DAW-01', 'Desarrollo web Primer Año'),
	 ('DAW-02', 'Desarrollo web Segundo Año'),
     ('DAM-02', 'Desarrollo multiplataforma Segundo Año');
     
INSERT INTO  ilerna.turno (nombre) 
VALUES 
	 ('Mañana'),
     ('Tarde');

INSERT INTO ilerna.asignatura (nombre, fp_id) 
VALUES 
	('Programacion I', '1'),
    ('Lenguaje de marca ', '1'),
    ('FOL', '1'),
    ('Sistemas informaticos', '1'),
    ('Base de datos', '1'),
    ('Entornos de desarrollo', '1'),
	('Programacion entorno al cliente', '2'),
    ('Programacion entorno al servidor', '2'),
    ('Empresas', '2'),
    ('Diseño de interfaces', '2'),
    ('Despliegues de Aplicaciones', '2'),
    ('Ingles', '2');

   
INSERT INTO ilerna.profesor (nombre, apellido, correo, telefono, contrasena)
VALUES
  ('Frank', 'Soltero', 'solterof@gmail.com', '555-1234', '$2a$10$Ma72XPk7ONK5y2tjqyyDdeTsh4c568TmNhHk21eEnAQYED2.Hqiy.'),
  ('Victor', 'Rodriguez', 'rodriguezv@gmail.com', '555-5678', '$2a$10$Ma72XPk7ONK5y2tjqyyDdeTsh4c568TmNhHk21eEnAQYED2.Hqiy.'),
  ('Cristina', 'Hernández', 'hernandezc@gmail.com', '555-9012', '$2a$10$Ma72XPk7ONK5y2tjqyyDdeTsh4c568TmNhHk21eEnAQYED2.Hqiy.'),
  ('Laura', 'Martínez', 'laura.martinez@gmail.com', '555-3456', '$2a$10$Ma72XPk7ONK5y2tjqyyDdeTsh4c568TmNhHk21eEnAQYED2.Hqiy.'),
  ('Santiago', 'Gómez', 'santiago.gomez@gmail.com', '555-7890', '$2a$10$Ma72XPk7ONK5y2tjqyyDdeTsh4c568TmNhHk21eEnAQYED2.Hqiy.'),
  ('Elena', 'Torres', 'elena.torres@gmail.com', '555-2345', '$2a$10$Ma72XPk7ONK5y2tjqyyDdeTsh4c568TmNhHk21eEnAQYED2.Hqiy.'),
  ('Carlos', 'Jiménez', 'carlos.jimenez@gmail.com', '555-6789', '$2a$10$Ma72XPk7ONK5y2tjqyyDdeTsh4c568TmNhHk21eEnAQYED2.Hqiy.'),
  ('María', 'López', 'maria.lopez@gmail.com', '555-1011', '$2a$10$Ma72XPk7ONK5y2tjqyyDdeTsh4c568TmNhHk21eEnAQYED2.Hqiy.'),
  ('Pedro', 'Ruiz', 'pedro.ruiz@gmail.com', '555-1213', '$2a$10$Ma72XPk7ONK5y2tjqyyDdeTsh4c568TmNhHk21eEnAQYED2.Hqiy.'),
  ('Juan Carlos', 'sulbaran', 'sulbaranjc@gmail.com', '555-1415', '$2a$10$aewA8WQIuJvs5nCtLCJKMOtbydRMC3GQLHJxNv9VYtbj1v45jn9fm');

INSERT INTO  ilerna.aula (nombre) 
VALUES 
	 ('4.1'),
     ('4.2');
     
INSERT INTO ilerna.modalidad (nombre)
VALUES
('Presencial'),
('Online');

INSERT INTO ilerna.dia_semana (id, nombre)
VALUES
  (1, 'lunes'),
  (2, 'Martes'),
  (3, 'Miercoles'),
  (4, 'jueves'),
  (5, 'viernes'),
  (6, 'sabado'),
  (7, 'domingo');
  
INSERT INTO ilerna.calendario (id_dia_semana, hora_inicio, hora_final)
VALUES
  (1, '08:30:00', '09:25:00'),
  (1, '09:25:00', '10:20:00'),
  (1, '10:20:00', '11:15:00'),
  (1, '11:15:00', '11:45:00'),
  (1, '11:45:00', '12:40:00'),
  (1, '12:40:00', '13:35:00'),
  (1, '13:35:00', '14:20:00'),
  (2, '08:30:00', '09:25:00'),
  (2, '09:25:00', '10:20:00'),
  (2, '10:20:00', '11:15:00'),
  (2, '11:15:00', '11:45:00'),
  (2, '11:45:00', '12:40:00'),
  (2, '12:40:00', '13:35:00'),
  (2, '13:35:00', '14:20:00'),
  (3, '08:30:00', '09:25:00'),
  (3, '09:25:00', '10:20:00'),
  (3, '10:20:00', '11:15:00'),
  (3, '11:15:00', '11:45:00'),
  (3, '11:45:00', '12:40:00'),
  (3, '12:40:00', '13:35:00'),
  (3, '13:35:00', '14:20:00'),
  (4, '08:30:00', '09:25:00'),
  (4, '09:25:00', '10:20:00'),
  (4, '10:20:00', '11:15:00'),
  (4, '11:15:00', '11:45:00'),
  (4, '11:45:00', '12:40:00'),
  (4, '12:40:00', '13:35:00'),
  (4, '13:35:00', '14:20:00'),
  (5, '08:30:00', '09:25:00'),
  (5, '09:25:00', '10:20:00'),
  (5, '10:20:00', '11:15:00'),
  (5, '11:15:00', '11:45:00'),
  (5, '11:45:00', '12:40:00'),
  (5, '12:40:00', '13:35:00'),
  (5, '13:35:00', '14:20:00');
  
  
INSERT INTO  ilerna.horario (nombre) 
VALUES 
	 ('P1'),
     ('P2'),
	 ('P3'),
     ('P4'),
	 ('P5'),
     ('P6');
     
INSERT INTO  ilerna.horario_detalle (id_horario, id_calendario) 
VALUES 
	 (1, 1),
     (1, 2),
	 (1, 15),
     (1, 16),
	 (1, 17),
     (1, 24),
	 (2, 3),
     (2, 5),
	 (2, 22),
     (2, 23),
	 (3, 6),
     (3, 7),
     (3, 8),
     (3, 9),
     (3, 29),
     (3, 30),
     (3, 31),
     (3, 33),
     (4, 10),
     (4, 12),
     (4, 13),
     (4, 19),
     (4, 20),
     (4, 21),
     (5, 14),
     (5, 34),
     (5, 35),
     (6, 26),
     (6, 27),
     (6, 28);

INSERT INTO ilerna.grupo (nombre,id_periodo,id_fp,id_turno,id_modalidad )
VALUES
  ("A", 1, 1, 1, 1),
  ("A", 1, 2, 1, 1);

INSERT INTO ilerna.periodo (nombre)
VALUES
  ("2022 - 2023"),
  ("2023 - 2024");



INSERT INTO ilerna.asignatura_grupo (id_asignatura, id_profesor, id_aula, id_horario, id_grupo)
VALUES
  (4, 2, 1, 1, 1),
  (2, 10, 1, 2, 1),
  (1, 1, 1, 3, 1),
  (5, 10, 1, 4, 1),
  (6, 10, 1, 5, 1),
  (3, 3, 1, 6, 1),
  (7, 4, 1, 1, 2),
  (8, 7, 1, 2, 2),
  (9, 6, 1, 3, 2),
  (10, 5, 1, 4, 2),
  (11, 1, 1, 5, 2),
  (12, 8, 1, 6, 2);  
  
  
INSERT INTO ilerna.alumno (dni, nombre, apellido, correo)
VALUES
  ('12345678A','Ana', 'López', 'ana.lopez@ejemplo.com'),
  ('23456789B','Carlos', 'Sánchez', 'carlos.sanchez@ejemplo.com'),
  ('34567890C','Lucía', 'García', 'lucia.garcia@ejemplo.com'),
  ('45678901D','Diego', 'Ramírez', 'diego.ramirez@ejemplo.com'),
  ('56789012E','Sofía', 'Martín', 'sofia.martin@ejemplo.com'),
  ('67890123F','David', 'Fernández', 'david.fernandez@ejemplo.com'),
  ('78901234G','Marta', 'Lorenzo', 'marta.lorenzo@ejemplo.com'),
  ('89012345H','Javier', 'Molina', 'javier.molina@ejemplo.com'),
  ('90123456I','Sara', 'Ortega', 'sara.ortega@ejemplo.com'),
  ('01234567J','Daniel', 'Rubio', 'daniel.rubio@ejemplo.com'),
  ('12345678K','Laura', 'Navarro', 'laura.navarro@ejemplo.com'),
  ('23456789L','Víctor', 'Díaz', 'victor.diaz@ejemplo.com'),
  ('34567890M','Clara', 'Prieto', 'clara.prieto@ejemplo.com'),
  ('45678901N','Pablo', 'Morales', 'pablo.morales@ejemplo.com'),
  ('56789012O','Patricia', 'Suárez', 'patricia.suarez@ejemplo.com'),
  ('67890123P','Francisco', 'Gomez', 'francisco.gomez@ejemplo.com'),
  ('78901234Q','Beatriz', 'Cano', 'beatriz.cano@ejemplo.com'),
  ('89012345R','Fernando', 'Bravo', 'fernando.bravo@ejemplo.com'),
  ('90123456S','Carmen', 'Solís', 'carmen.solis@ejemplo.com'),
  ('01234567T','Jorge', 'Iglesias', 'jorge.iglesias@ejemplo.com');


INSERT INTO ilerna.alumno_grupo (id_grupo, id_alumno)
VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (1, 4),
  (1, 5),
  (1, 6),
  (1, 7),
  (1, 8),
  (1, 9),
  (1, 10),
  (2, 11),
  (2, 12),
  (2, 13),
  (2, 14),
  (2, 15),
  (2, 16),
  (2, 17),
  (2, 18),
  (2, 19),
  (2, 20);

   
   
INSERT INTO  ilerna.tipo_asistencia (nombre) 
VALUES 
	 ('Justificada'),
     ('Injustificada'),
     ('Retraso');
     

INSERT INTO ilerna.asistencia (fecha, id_alumno, id_horario_detalle, id_tipo_asistencia)
VALUES
  ('2023-04-01',1,1,1),
  ('2023-04-05',2,2,2),
  ('2023-04-07',3,3,1),
  ('2023-04-10',4,4,2),
  ('2023-04-28',5,5,2),
  ('2023-04-01',6,6,2),
  ('2023-04-05',7,7,2),
  ('2023-04-07',8,7,2),
  ('2023-04-10',9,7,2),
  ('2023-04-28',10,7,2);
  

     
     

    

