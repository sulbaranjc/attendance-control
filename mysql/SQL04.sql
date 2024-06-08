--  todas las asignaturas grupo
SELECT 
    AG.id AS id_asignatura_grupo,
    A.id AS id_asignatura,
    A.nombre AS nombre_asignatura,
    P.id AS id_profesor,
    P.nombre AS nombre_profesor,
    AU.id AS id_aula,
    AU.nombre AS nombre_aula,
    H.id AS id_horario,
    H.nombre AS nombre_horario,
    G.id AS id_grupo,
    G.nombre AS nombre_grupo
FROM 
    ilerna.asignatura_grupo AG
INNER JOIN 
    ilerna.asignatura A ON AG.id_asignatura = A.id
INNER JOIN 
    ilerna.profesor P ON AG.id_profesor = P.id
INNER JOIN 
    ilerna.aula AU ON AG.id_aula = AU.id
INNER JOIN 
    ilerna.horario H ON AG.id_horario = H.id
INNER JOIN 
    ilerna.grupo G ON AG.id_grupo = G.id;
