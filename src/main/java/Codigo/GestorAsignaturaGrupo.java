package Codigo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorAsignaturaGrupo {
    Statement consulta;
    Conexion c = new Conexion();

    public List<AsignaturaGrupo> listar(int idProfesor , int idPeriodo) throws SQLException {
        ResultSet rs = null;
        List<AsignaturaGrupo> asignaturasGrupo;
        asignaturasGrupo = new ArrayList<>();
        consulta = c.conectar().createStatement();
        String cadena = "SELECT asg.id , asignatura.id as idAsignatura , asignatura.nombre as nombreIdAsignatura , " +
                "profesor.id as idprofesor , profesor.nombre as nombreidprofesor , aula.id as idAula , " +
                "aula.nombre as nombreIdAula , asg.id_horario as idHorario , horario.nombre as nombreIdHorario , " +
                "asg.id_grupo as idgrupo , grupo.nombre as nombreIdGrupo , fp.nombre , " +
                "periodo.nombre as nombreIdPeriodo , periodo.id as idPeriodo "+
                "FROM asignatura_grupo as asg , asignatura , " +
                "profesor , aula, grupo , horario , fp , periodo " +
                "WHERE asg.id_asignatura = asignatura.id AND " +
                "grupo.id_fp = fp.id AND " +
                "asg.id_profesor = profesor.id AND " +
                "asg.id_aula = aula.id AND " +
                "asg.id_grupo = grupo.id AND " +
                "asg.id_horario = horario.id AND " +
                "grupo.id_periodo = periodo.id AND " +
                "asg.id_profesor = "+idProfesor+" AND " +
                "grupo.id_periodo = "+idPeriodo+" " +
                "ORDER BY profesor.nombre;";
        // System.out.println(cadena);
        rs = consulta.executeQuery(cadena);
        while (rs.next()) {
            AsignaturaGrupo asignaturaGrupo = new AsignaturaGrupo();
            asignaturaGrupo.setId(rs.getInt("id"));
            asignaturaGrupo.setIdAsignatura(rs.getInt("idAsignatura"));
            asignaturaGrupo.setNombreIdAsignatura(rs.getString("nombreIdAsignatura"));
            asignaturaGrupo.setIdProfesor(rs.getInt("idprofesor"));
            asignaturaGrupo.setNombreIdProfesor(rs.getString("nombreidprofesor"));
            asignaturaGrupo.setIdAula(rs.getInt("idAula"));
            asignaturaGrupo.setNombreIdAula(rs.getString("nombreIdAula"));
            asignaturaGrupo.setIdHorario(rs.getInt("idHorario"));
            asignaturaGrupo.setNombreIdHorario(rs.getString("nombreIdHorario"));
            asignaturaGrupo.setIdGrupo(rs.getInt("idgrupo"));
            asignaturaGrupo.setNombreIdGrupo(rs.getString("nombreIdGrupo"));
            asignaturaGrupo.setIdPeriodo(rs.getInt("idperiodo"));
            asignaturaGrupo.setNombreIdPeriodo(rs.getString("nombreIdPeriodo"));
            asignaturasGrupo.add(asignaturaGrupo);
        }
        return asignaturasGrupo;
    }

}
