package Codigo;

public class AsistenciaDetalle {
    private int idAsistencia;
    private String fecha;
    private int idAlumno;
    private String nombreAlumno;
    private String apellidoAlumno;
    private int idHorarioDetalle;
    private String nombreDiaSemana;
    private String horaInicio;
    private String horaFinal;
    private int idTipoAsistencia;
    private String nombreTipoAsistencia;
    private int idAsignaturaGrupo;
    private String nombreAsignatura;

    // Constructor vacío
    public AsistenciaDetalle() {
    }

    // Constructor con todos los campos
    public AsistenciaDetalle(int idAsistencia, String fecha, int idAlumno, String nombreAlumno,
                             String apellidoAlumno, int idHorarioDetalle, String nombreDiaSemana,
                             String horaInicio, String horaFinal, int idTipoAsistencia,
                             String nombreTipoAsistencia, int idAsignaturaGrupo, String nombreAsignatura) {
        this.idAsistencia = idAsistencia;
        this.fecha = fecha;
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.idHorarioDetalle = idHorarioDetalle;
        this.nombreDiaSemana = nombreDiaSemana;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.idTipoAsistencia = idTipoAsistencia;
        this.nombreTipoAsistencia = nombreTipoAsistencia;
        this.idAsignaturaGrupo = idAsignaturaGrupo;
        this.nombreAsignatura = nombreAsignatura;
    }

    // Getters and setters
    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public int getIdHorarioDetalle() {
        return idHorarioDetalle;
    }

    public void setIdHorarioDetalle(int idHorarioDetalle) {
        this.idHorarioDetalle = idHorarioDetalle;
    }

    public String getNombreDiaSemana() {
        return nombreDiaSemana;
    }

    public void setNombreDiaSemana(String nombreDiaSemana) {
        this.nombreDiaSemana = nombreDiaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getIdTipoAsistencia() {
        return idTipoAsistencia;
    }

    public void setIdTipoAsistencia(int idTipoAsistencia) {
        this.idTipoAsistencia = idTipoAsistencia;
    }

    public String getNombreTipoAsistencia() {
        return nombreTipoAsistencia;
    }

    public void setNombreTipoAsistencia(String nombreTipoAsistencia) {
        this.nombreTipoAsistencia = nombreTipoAsistencia;
    }

    public int getIdAsignaturaGrupo() {
        return idAsignaturaGrupo;
    }

    public void setIdAsignaturaGrupo(int idAsignaturaGrupo) {
        this.idAsignaturaGrupo = idAsignaturaGrupo;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
}
