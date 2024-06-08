SELECT 
	AG.id AS id_asignatura_grupo,
    H.id AS id_horario,
    H.nombre AS nombre_horario,
    A.nombre AS nombre_asignatura,
    DS.nombre AS dia_semana,
    C.id AS id_horario_detalle,
    C.hora_inicio,
    C.hora_final
FROM 
    ilerna.asignatura_grupo AG
INNER JOIN 
    ilerna.asignatura A ON AG.id_asignatura = A.id  -- Unir con la tabla asignatura
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
