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
    ilerna.tipo_asistencia TA ON A.id_tipo_asistencia = TA.id;

