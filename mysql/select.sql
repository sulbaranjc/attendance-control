-- todas las tablas
USE ilerna;
select * from turno;
select * from fp;
select * from asignatura;
select * from profesor;
select * from aula;
select * from modalidad;
select * from grupo;
select * from dia_semana;
select * from calendario;
select * from horario;
select * from asignatura_grupo;
select * from alumno;
select * from alumno_grupo;
select * from tipo_asistencia;
select * from asistencia;

-- lista de profesores 
select nombre,apellido from profesor;

-- lista de fp
select nombre from fp;

-- lista de turnos
select nombre from turno;


-- lista de grupo
SELECT grupo.id, grupo.nombre,periodo.nombre,fp.nombre as fp, turno.nombre as turno, modalidad.nombre as modalidad 
	FROM grupo, fp, turno, modalidad, periodo  
    WHERE grupo.id_fp = fp.id 
	  AND grupo.id_turno = turno.id 
      AND grupo.id_periodo = periodo.id 
      AND grupo.id_modalidad = modalidad.id;


-- lista de alumno por grupo
SELECT  alumno.nombre, alumno.apellido 
	FROM alumno_grupo, alumno 
	WHERE id_grupo = 1 AND alumno_grupo.id_alumno = alumno.id;

-- lista de asignatura fp
SELECT asignatura.nombre, fp.nombre as fp 
	FROM asignatura, fp 
	WHERE asignatura.fp_id = fp.id;
    
-- asignaturas de un profesor 
SELECT asignatura.nombre, profesor.nombre as profesor, aula.nombre as aula, asg.id_horario
	FROM asignatura_grupo as asg, asignatura, profesor, aula
	WHERE asg.id_asignatura = asignatura.id AND asg.id_profesor = profesor.id AND asg.id_aula = aula.id
    ORDER BY profesor.nombre;

-- asignaturas de un profesor horario




-- asignaturas de un profesor horario
SELECT asg.id , asignatura.id as idAsignatura , asignatura.nombre as nombreIdAsignatura ,
                profesor.id as idprofesor , profesor.nombre as nombreidprofesor , aula.id as idAula ,
                aula.nombre as nombreIdAula , asg.id_horario as idHorario , horario.nombre as nombreIdHorario ,
                asg.id_grupo as idgrupo , grupo.nombre as nombreIdGrupo, fp.nombre  FROM asignatura_grupo as asg , asignatura ,
                profesor , aula, grupo , horario , fp
                WHERE asg.id_asignatura = asignatura.id AND
                grupo.id_fp = fp.id AND
                asg.id_profesor = profesor.id AND
                asg.id_aula = aula.id AND
                asg.id_grupo = grupo.id AND
                asg.id_horario = horario.id AND
                asg.id_profesor = 2
                ORDER BY profesor.nombre;

-- asignaturas de un profesor horario es igual
SELECT asg.id , asignatura.id as idAsignatura , asignatura.nombre as nombreIdAsignatura , profesor.id as idprofesor , profesor.nombre as nombreidprofesor , aula.id as idAula , aula.nombre as nombreIdAula , asg.id_horario as idHorario , horario.nombre as nombreIdHorario , asg.id_grupo as idgrupo , grupo.nombre as nombreIdGrupo , fp.nombre FROM asignatura_grupo as asg , asignatura , profesor , aula, grupo , horario , fp WHERE asg.id_asignatura = asignatura.id AND grupo.id_fp = fp.id AND asg.id_profesor = profesor.id AND asg.id_aula = aula.id AND asg.id_grupo = grupo.id AND asg.id_horario = horario.id AND asg.id_profesor = 1 ORDER BY profesor.nombre;


    -- lista de horario por profesor
SELECT asignatura.nombre, profesor.nombre as profesor, aula.nombre as aula,
dia_semana.nombre as dia, calendario.hora_inicio, calendario.hora_final
	FROM asignatura_grupo as asg, asignatura, profesor, aula, horario_detalle as h_d, calendario, dia_semana
	WHERE asg.id_asignatura = asignatura.id AND asg.id_profesor = profesor.id 
		AND asg.id_aula = aula.id AND asg.id_asignatura = 2 AND asg.id_horario = h_d.id_horario 
        AND h_d.id_calendario = calendario.id AND calendario.id_dia_semana = dia_semana.id
	ORDER BY dia_semana.id , calendario.hora_inicio;
    
-- lista de horario completo
SELECT asignatura.nombre, profesor.nombre as profesor, aula.nombre as aula,
dia_semana.nombre as dia, calendario.hora_inicio, calendario.hora_final
	FROM asignatura_grupo as asg, asignatura, profesor, aula, horario_detalle as h_d, calendario, dia_semana
	WHERE asg.id_asignatura = asignatura.id AND asg.id_profesor = profesor.id 
		AND asg.id_aula = aula.id AND asg.id_horario = h_d.id_horario 
        AND h_d.id_calendario = calendario.id AND calendario.id_dia_semana = dia_semana.id
    ORDER BY dia_semana.id , calendario.hora_inicio;    
    
    
    
-- prueba
SELECT CONCAT(calendario.hora_inicio, '-', calendario.hora_final) AS horas,
    GROUP_CONCAT(DISTINCT CASE WHEN dia_semana.nombre = 'lunes' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre, ' - ', aula.nombre) END) AS lunes,
    GROUP_CONCAT(DISTINCT CASE WHEN dia_semana.nombre = 'martes' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre, ' - ', aula.nombre) END) AS martes,
    GROUP_CONCAT(DISTINCT CASE WHEN dia_semana.nombre = 'miércoles' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre, ' - ', aula.nombre) END) AS miercoles,
    GROUP_CONCAT(DISTINCT CASE WHEN dia_semana.nombre = 'jueves' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre, ' - ', aula.nombre) END) AS jueves,
    GROUP_CONCAT(DISTINCT CASE WHEN dia_semana.nombre = 'viernes' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre, ' - ', aula.nombre) END) AS viernes
FROM asignatura_grupo as asg, asignatura, profesor, aula, horario_detalle as h_d, calendario, dia_semana
WHERE asg.id_asignatura = asignatura.id AND asg.id_profesor = profesor.id 
    AND asg.id_aula = aula.id AND asg.id_horario = h_d.id_horario 
    AND h_d.id_calendario = calendario.id AND calendario.id_dia_semana = dia_semana.id
GROUP BY calendario.hora_inicio, calendario.hora_final;

-- otra forma
SELECT CONCAT(calendario.hora_inicio, ' - ', calendario.hora_final) AS horario,
  MAX(CASE WHEN dia_semana.id = 1 THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre,' - ',grupo.nombre,' - ',periodo.nombre) ELSE '' END) AS lunes,
  MAX(CASE WHEN dia_semana.id = 2 THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS martes,
  MAX(CASE WHEN dia_semana.id = 3 THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS miércoles,
  MAX(CASE WHEN dia_semana.id = 4 THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS jueves,
  MAX(CASE WHEN dia_semana.id = 5 THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS viernes
FROM asignatura_grupo AS asg
JOIN asignatura ON asg.id_asignatura = asignatura.id
JOIN grupo ON  asg.id_grupo = grupo.id
JOIN periodo ON  grupo.id_periodo = periodo.id
JOIN profesor ON asg.id_profesor = profesor.id 
JOIN aula ON asg.id_aula = aula.id 
JOIN horario_detalle AS h_d ON asg.id_horario = h_d.id_horario 
JOIN calendario ON h_d.id_calendario = calendario.id 
JOIN dia_semana ON calendario.id_dia_semana = dia_semana.id
WHERE 
	grupo.id = 1 AND  periodo.id = 1
GROUP BY CONCAT(calendario.hora_inicio, ' - ', calendario.hora_final);


-- sin periodo
SELECT CONCAT(calendario.hora_inicio, ' - ', calendario.hora_final) AS horario,
  MAX(CASE WHEN dia_semana.id = 1 THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS lunes,
  MAX(CASE WHEN dia_semana.id = 2 THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS martes,
  MAX(CASE WHEN dia_semana.id = 3 THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS miércoles,
  MAX(CASE WHEN dia_semana.id = 4 THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS jueves,
  MAX(CASE WHEN dia_semana.id = 5 THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS viernes
FROM asignatura_grupo AS asg
JOIN asignatura ON asg.id_asignatura = asignatura.id
JOIN grupo ON  asg.id_grupo = grupo.id
JOIN periodo ON  grupo.id_periodo = periodo.id
JOIN profesor ON asg.id_profesor = profesor.id 
JOIN aula ON asg.id_aula = aula.id 
JOIN horario_detalle AS h_d ON asg.id_horario = h_d.id_horario 
JOIN calendario ON h_d.id_calendario = calendario.id 
JOIN dia_semana ON calendario.id_dia_semana = dia_semana.id
WHERE 
		grupo.id = 1 
    -- AND calendario.id = 11
GROUP BY CONCAT(calendario.hora_inicio, ' - ', calendario.hora_final);

insert into alumno(nombre,apellido,correo) values ('JUAN','Sulbaran','sulbaranjc@gmail.com');    
SELECT asignatura.*, fp.nombre as fp_nombre FROM asignatura, fp WHERE asignatura.fp_id = fp.id ORDER BY fp.nombre;    
select asg.*, fp.nombre as fp_nombre FROM asignatura as asg , fp WHERE asg.fp_id = fp.id and asg.id=1;
select asg.*, fp.nombre as fp_nombre FROM asignatura AS asg , fp WHERE asg.fp_id = fp.id and asg.id=2;
select * from tipo_asistencia WHERE id=9;


-- Consulta de los horarios de una materia y profesor específico.
SELECT
    CONCAT(d.nombre, ' - ', c.hora_inicio, ' - ', c.hora_final) AS Horario_Completo,
    hd.id AS Id_Horario_Detalle
FROM
    profesor p
JOIN
    asignatura_grupo ag ON p.id = ag.id_profesor
JOIN
    asignatura a ON ag.id_asignatura = a.id
JOIN
    horario_detalle hd ON ag.id_horario = hd.id_horario
JOIN
    calendario c ON hd.id_calendario = c.id
JOIN
    dia_semana d ON c.id_dia_semana = d.id
WHERE
    p.id = 10  AND -- ID del profesor
    ag.id = 11     -- ASIGNATURA DEL GRUPO
ORDER BY
    d.id, c.hora_inicio;



-- Muestra los alumnos de un grupo en específico.
SELECT
	a.id,
    CONCAT(a.nombre, ' ', a.apellido) AS Nombre_Completo
FROM
    ilerna.alumno a
JOIN
    ilerna.alumno_grupo ag ON a.id = ag.id_alumno
WHERE
    ag.id_grupo = 1  -- Cambia este valor según el grupo que quieras consultar
ORDER BY
    a.nombre , a.apellido;

-- inasistencias x alumno
SELECT
    A.id AS id_asistencia,
    A.fecha,
    AL.id AS id_alumno,
    AL.nombre,
    AL.apellido,
    HD.id AS id_horario_detalle,
    DS.nombre AS nombre_dia_semana,
    C.hora_inicio,
    C.hora_final,
    A.id_tipo_asistencia,
    TA.nombre AS nombre_tipo_asistencia
FROM
    ilerna.asistencia A
INNER JOIN
    ilerna.alumno AL ON A.id_alumno = AL.id
INNER JOIN
    ilerna.horario_detalle HD ON A.id_horario_detalle = HD.id
INNER JOIN
    ilerna.calendario C ON HD.id_calendario = C.id
INNER JOIN
    ilerna.dia_semana DS ON C.id_dia_semana = DS.id
INNER JOIN
    ilerna.tipo_asistencia TA ON A.id_tipo_asistencia = TA.id
WHERE
    AL.id = 1;  -- Asumiendo que quieres consultar por el alumno con ID 1

-- horario de un materia
SELECT
    H.id AS id_horario,
    H.nombre AS nombre_horario,
    DS.nombre AS dia_semana,
    C.hora_inicio,
    C.hora_final
FROM
    ilerna.asignatura_grupo AG
INNER JOIN
    ilerna.horario H ON AG.id_horario = H.id
INNER JOIN
    ilerna.horario_detalle HD ON H.id = HD.id_horario
INNER JOIN
    ilerna.calendario C ON HD.id_calendario = C.id
INNER JOIN
    ilerna.dia_semana DS ON C.id_dia_semana = DS.id
WHERE
    AG.id = 1;
