-- sin periodo
SELECT CONCAT(calendario.hora_inicio, ' - ', calendario.hora_final) AS horario,
  MAX(CASE WHEN dia_semana.id = 1 THEN asignatura.nombre ELSE '' END) AS lunes,
  MAX(CASE WHEN dia_semana.id = 2 THEN asignatura.nombre ELSE '' END) AS martes,
  MAX(CASE WHEN dia_semana.id = 3 THEN asignatura.nombre ELSE '' END) AS miércoles,
  MAX(CASE WHEN dia_semana.id = 4 THEN asignatura.nombre ELSE '' END) AS jueves,
  MAX(CASE WHEN dia_semana.id = 5 THEN asignatura.nombre ELSE '' END) AS viernes
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
	asg.id_profesor	= 10
    AND grupo.id_periodo = 1
GROUP BY CONCAT(calendario.hora_inicio, ' - ', calendario.hora_final);