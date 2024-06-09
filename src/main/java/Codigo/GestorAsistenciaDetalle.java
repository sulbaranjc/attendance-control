package Codigo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para gestionar los detalles de asistencias de los alumnos
 */
public class GestorAsistenciaDetalle {
    Statement consulta;
    Conexion c = new Conexion();

    public List<AsistenciaDetalle> listar(int asigGruId) throws SQLException {
        ResultSet rs = null;
        List<AsistenciaDetalle> detallesAsistencia = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT A.id AS id_asistencia, A.fecha, AL.id AS id_alumno, AL.nombre AS nombre_alumno, " +
                "AL.apellido AS apellido_alumno, HD.id AS id_horario_detalle, DS.nombre AS nombre_dia_semana, " +
                "C.hora_inicio, C.hora_final, A.id_tipo_asistencia, TA.nombre AS nombre_tipo_asistencia, " +
                "AG.id AS id_asignatura_grupo, ASG.nombre AS nombre_asignatura " +
                "FROM asistencia A " +
                "INNER JOIN alumno AL ON A.id_alumno = AL.id " +
                "INNER JOIN horario_detalle HD ON A.id_horario_detalle = HD.id " +
                "INNER JOIN calendario C ON HD.id_calendario = C.id " +
                "INNER JOIN dia_semana DS ON C.id_dia_semana = DS.id " +
                "INNER JOIN tipo_asistencia TA ON A.id_tipo_asistencia = TA.id " +
                "INNER JOIN asignatura_grupo AG ON HD.id_horario = AG.id_horario " +
                "INNER JOIN asignatura ASG ON AG.id_asignatura = ASG.id "+
                "WHERE "+
                " AG.id = "+asigGruId+";";
        System.out.println(cadena);
        rs = consulta.executeQuery(cadena);
        while (rs.next()) {
            AsistenciaDetalle asistencia = new AsistenciaDetalle(
                    rs.getInt("id_asistencia"),
                    rs.getString("fecha"),
                    rs.getInt("id_alumno"),
                    rs.getString("nombre_alumno"),
                    rs.getString("apellido_alumno"),
                    rs.getInt("id_horario_detalle"),
                    rs.getString("nombre_dia_semana"),
                    rs.getString("hora_inicio"),
                    rs.getString("hora_final"),
                    rs.getInt("id_tipo_asistencia"),
                    rs.getString("nombre_tipo_asistencia"),
                    rs.getInt("id_asignatura_grupo"),
                    rs.getString("nombre_asignatura")
            );
            detallesAsistencia.add(asistencia);
        }
        return detallesAsistencia;
    }

    public List<AsistenciaDetalle> listarFiltrados(int asigGruId,String filtro) throws SQLException {
        ResultSet rs = null;
        List<AsistenciaDetalle> detallesAsistencia = new ArrayList<>();
        consulta = c.conectar().createStatement();

        String cadena = "SELECT A.id AS id_asistencia, A.fecha, AL.id AS id_alumno, AL.nombre AS nombre_alumno, " +
                "AL.apellido AS apellido_alumno, HD.id AS id_horario_detalle, DS.nombre AS nombre_dia_semana, " +
                "C.hora_inicio, C.hora_final, A.id_tipo_asistencia, TA.nombre AS nombre_tipo_asistencia, " +
                "AG.id AS id_asignatura_grupo, ASG.nombre AS nombre_asignatura " +
                "FROM asistencia A " +
                "INNER JOIN alumno AL ON A.id_alumno = AL.id " +
                "INNER JOIN horario_detalle HD ON A.id_horario_detalle = HD.id " +
                "INNER JOIN calendario C ON HD.id_calendario = C.id " +
                "INNER JOIN dia_semana DS ON C.id_dia_semana = DS.id " +
                "INNER JOIN tipo_asistencia TA ON A.id_tipo_asistencia = TA.id " +
                "INNER JOIN asignatura_grupo AG ON HD.id_horario = AG.id_horario " +
                "INNER JOIN asignatura ASG ON AG.id_asignatura = ASG.id " +
                "WHERE " +
                "(AG.id = " + asigGruId + " " +
                "AND( AL.nombre LIKE '%" + filtro + "%' " +
                "OR A.fecha LIKE '%" + filtro + "%' " +
                "OR AL.apellido LIKE '%" + filtro + "%' " +
                "OR DS.nombre LIKE '%" + filtro + "%' " +
                "OR TA.nombre LIKE '%" + filtro + "%' " +
                "OR ASG.nombre LIKE '%" + filtro + "%')) " +
                "ORDER BY A.fecha;";
        System.out.println(cadena);
        rs = consulta.executeQuery(cadena);
        while (rs.next()) {
            AsistenciaDetalle asistencia = new AsistenciaDetalle(
                    rs.getInt("id_asistencia"),
                    rs.getString("fecha"),
                    rs.getInt("id_alumno"),
                    rs.getString("nombre_alumno"),
                    rs.getString("apellido_alumno"),
                    rs.getInt("id_horario_detalle"),
                    rs.getString("nombre_dia_semana"),
                    rs.getString("hora_inicio"),
                    rs.getString("hora_final"),
                    rs.getInt("id_tipo_asistencia"),
                    rs.getString("nombre_tipo_asistencia"),
                    rs.getInt("id_asignatura_grupo"),
                    rs.getString("nombre_asignatura")
            );
            detallesAsistencia.add(asistencia);
        }
        return detallesAsistencia;
    }

    private int convertirANumero(String filtro) {
        try {
            return Integer.parseInt(filtro);
        } catch (NumberFormatException e) {
            return -1; // Devuelve -1 si no puede convertir el filtro a número.
        }
    }




    public AsistenciaDetalle consultarUn(int id) throws SQLException {
        AsistenciaDetalle asistencia = null;
        ResultSet rs = null;
        consulta = c.conectar().createStatement();
        String cadena = "SELECT A.id AS id_asistencia, A.fecha, AL.id AS id_alumno, AL.nombre AS nombre_alumno, " +
                "AL.apellido AS apellido_alumno, HD.id AS id_horario_detalle, DS.nombre AS nombre_dia_semana, " +
                "C.hora_inicio, C.hora_final, A.id_tipo_asistencia, TA.nombre AS nombre_tipo_asistencia, " +
                "AG.id AS id_asignatura_grupo, ASG.nombre AS nombre_asignatura " +
                "FROM asistencia A " +
                "INNER JOIN alumno AL ON A.id_alumno = AL.id " +
                "INNER JOIN horario_detalle HD ON A.id_horario_detalle = HD.id " +
                "INNER JOIN calendario C ON HD.id_calendario = C.id " +
                "INNER JOIN dia_semana DS ON C.id_dia_semana = DS.id " +
                "INNER JOIN tipo_asistencia TA ON A.id_tipo_asistencia = TA.id " +
                "INNER JOIN asignatura_grupo AG ON HD.id_horario = AG.id_horario " +
                "INNER JOIN asignatura ASG ON AG.id_asignatura = ASG.id " +
                "WHERE A.id = " + id;
        rs = consulta.executeQuery(cadena);
        if (rs.next()) {
            asistencia = new AsistenciaDetalle(
                    rs.getInt("id_asistencia"),
                    rs.getString("fecha"),
                    rs.getInt("id_alumno"),
                    rs.getString("nombre_alumno"),
                    rs.getString("apellido_alumno"),
                    rs.getInt("id_horario_detalle"),
                    rs.getString("nombre_dia_semana"),
                    rs.getString("hora_inicio"),
                    rs.getString("hora_final"),
                    rs.getInt("id_tipo_asistencia"),
                    rs.getString("nombre_tipo_asistencia"),
                    rs.getInt("id_asignatura_grupo"),
                    rs.getString("nombre_asignatura")
            );
        }
        return asistencia;
    }
}
