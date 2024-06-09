package Codigo;

public class AlumnoGrupo {
    private int id;
    private int idAlumno;
    private String nombreIdAlumno;
    private int idGrupo;
    private String nombreIdGrupo;
    private String nombreIdfp;
    private String nombreIdPeriodo;
    private int idPeriodo;

    public AlumnoGrupo() {
    }

    // Constructor completo incluyendo los nuevos campos
    public AlumnoGrupo(int id, int idAlumno, String nombreIdAlumno, int idGrupo, String nombreIdGrupo, String nombreIdfp, String nombreIdPeriodo, int idPeriodo) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.nombreIdAlumno = nombreIdAlumno;
        this.idGrupo = idGrupo;
        this.nombreIdGrupo = nombreIdGrupo;
        this.nombreIdfp = nombreIdfp;
        this.nombreIdPeriodo = nombreIdPeriodo;
        this.idPeriodo = idPeriodo;
    }

    // Constructor sin el campo id pero incluyendo los nuevos campos
    public AlumnoGrupo(int idAlumno, String nombreIdAlumno, int idGrupo, String nombreIdGrupo, String nombreIdfp, String nombreIdPeriodo, int idPeriodo) {
        this.idAlumno = idAlumno;
        this.nombreIdAlumno = nombreIdAlumno;
        this.idGrupo = idGrupo;
        this.nombreIdGrupo = nombreIdGrupo;
        this.nombreIdfp = nombreIdfp;
        this.nombreIdPeriodo = nombreIdPeriodo;
        this.idPeriodo = idPeriodo;
    }

    // Getters y Setters incluyendo los nuevos campos
    public String getNombreIdPeriodo() {
        return nombreIdPeriodo;
    }

    public void setNombreIdPeriodo(String nombreIdPeriodo) {
        this.nombreIdPeriodo = nombreIdPeriodo;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getNombreIdfp() {
        return nombreIdfp;
    }

    public void setNombreIdfp(String nombreIdfp) {
        this.nombreIdfp = nombreIdfp;
    }

    public String getNombreIdGrupo() {
        return nombreIdGrupo;
    }

    public void setNombreIdGrupo(){
        this.nombreIdGrupo = nombreIdGrupo;
    }
}
