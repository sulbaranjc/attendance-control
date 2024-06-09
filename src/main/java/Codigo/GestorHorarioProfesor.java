package Codigo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorHorarioProfesor {

    Statement consulta;
    Conexion c = new Conexion();

    /**
     * Método para obtener el horario de un profesor dado su ID y el ID del periodo.
     *
     * @param idProfesor ID del profesor
     * @param idPeriodo  ID del periodo
     * @return Lista de objetos HorarioProfesor
     * @throws SQLException en caso de error de acceso a la base de datos
     */
    public List<HorarioProfesor> obtenerHorario(int idProfesor, int idPeriodo) throws SQLException {
        ResultSet rs = null;
        List<HorarioProfesor> horarioList = new ArrayList<>();
        consulta = c.conectar().createStatement();

        String sql = "SELECT CONCAT(calendario.hora_inicio, '-', calendario.hora_final) AS horario, " +
                "MAX(CASE WHEN dia_semana.id = 1 THEN asignatura.nombre ELSE '' END) AS lunes, " +
                "MAX(CASE WHEN dia_semana.id = 2 THEN asignatura.nombre ELSE '' END) AS martes, " +
                "MAX(CASE WHEN dia_semana.id = 3 THEN asignatura.nombre ELSE '' END) AS miercoles, " +
                "MAX(CASE WHEN dia_semana.id = 4 THEN asignatura.nombre ELSE '' END) AS jueves, " +
                "MAX(CASE WHEN dia_semana.id = 5 THEN asignatura.nombre ELSE '' END) AS viernes " +
                "FROM asignatura_grupo AS asg " +
                "JOIN asignatura ON asg.id_asignatura = asignatura.id " +
                "JOIN grupo ON asg.id_grupo = grupo.id " +
                "JOIN profesor ON asg.id_profesor = profesor.id " +
                "JOIN aula ON asg.id_aula = aula.id " +
                "JOIN horario_detalle AS h_d ON asg.id_horario = h_d.id_horario " +
                "JOIN calendario ON h_d.id_calendario = calendario.id " +
                "JOIN dia_semana ON calendario.id_dia_semana = dia_semana.id " +
                "WHERE asg.id_profesor = " + idProfesor + " AND grupo.id_periodo = " + idPeriodo + " " +
                "GROUP BY CONCAT(calendario.hora_inicio, '-', calendario.hora_final)";

        System.out.println(sql);
        rs = consulta.executeQuery(sql);
        while (rs.next()) {
            HorarioProfesor horarioProfesor = new HorarioProfesor(
                    rs.getString("horario"),
                    rs.getString("lunes"),
                    rs.getString("martes"),
                    rs.getString("miercoles"),
                    rs.getString("jueves"),
                    rs.getString("viernes")
            );
            horarioList.add(horarioProfesor);
        }
        return horarioList;
    }
}
