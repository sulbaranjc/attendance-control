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
