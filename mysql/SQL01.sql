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
    TA.id AS id_tipo_asistencia,
    TA.nombre AS nombre_tipo_asistencia,
    AG.id AS id_asignatura_grupo,
    ASG.nombre AS nombre_asignatura
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
INNER JOIN 
    ilerna.asignatura_grupo AG ON HD.id_horario = AG.id_horario
INNER JOIN 
    ilerna.asignatura ASG ON AG.id_asignatura = ASG.id
WHERE 
    AG.id = 1;  -- X es el ID del grupo de asignatura específico que quieres filtrar	
