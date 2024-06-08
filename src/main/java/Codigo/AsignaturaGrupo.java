package Codigo;

public class AsignaturaGrupo {
    private int id;
    private int idAsignatura;
    private String nombreIdAsignatura;
    private int idProfesor;
    private String nombreIdProfesor;
    private int idAula;
    private String nombreIdAula;
    private int idHorario;
    private String nombreIdHorario;
    private int idGrupo;
    private String nombreIdGrupo;
    private String nombreIdfp;
    private String nombreIdPeriodo;
    private int idPeriodo;

    public AsignaturaGrupo() {
    }

    // Constructor completo incluyendo los nuevos campos
    public AsignaturaGrupo(int id, int idAsignatura, String nombreIdAsignatura, int idProfesor, String nombreIdProfesor, int idAula, String nombreIdAula, int idHorario, String nombreIdHorario, int idGrupo, String nombreIdGrupo, String nombreIdfp, String nombreIdPeriodo, int idPeriodo) {
        this.id = id;
        this.idAsignatura = idAsignatura;
        this.nombreIdAsignatura = nombreIdAsignatura;
        this.idProfesor = idProfesor;
        this.nombreIdProfesor = nombreIdProfesor;
        this.idAula = idAula;
        this.nombreIdAula = nombreIdAula;
        this.idHorario = idHorario;
        this.nombreIdHorario = nombreIdHorario;
        this.idGrupo = idGrupo;
        this.nombreIdGrupo = nombreIdGrupo;
        this.nombreIdfp = nombreIdfp;
        this.nombreIdPeriodo = nombreIdPeriodo;
        this.idPeriodo = idPeriodo;
    }

    // Constructor sin el campo id pero incluyendo los nuevos campos
    public AsignaturaGrupo(int idAsignatura, String nombreIdAsignatura, int idProfesor, String nombreIdProfesor, int idAula, String nombreIdAula, int idHorario, String nombreIdHorario, int idGrupo, String nombreIdGrupo, String nombreIdfp, String nombreIdPeriodo, int idPeriodo) {
        this.idAsignatura = idAsignatura;
        this.nombreIdAsignatura = nombreIdAsignatura;
        this.idProfesor = idProfesor;
        this.nombreIdProfesor = nombreIdProfesor;
        this.idAula = idAula;
        this.nombreIdAula = nombreIdAula;
        this.idHorario = idHorario;
        this.nombreIdHorario = nombreIdHorario;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreIdAsignatura() {
        return nombreIdAsignatura;
    }

    public void setNombreIdAsignatura(String nombreIdAsignatura) {
        this.nombreIdAsignatura = nombreIdAsignatura;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreIdProfesor() {
        return nombreIdProfesor;
    }

    public void setNombreIdProfesor(String nombreIdProfesor) {
        this.nombreIdProfesor = nombreIdProfesor;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public String getNombreIdAula() {
        return nombreIdAula;
    }

    public void setNombreIdAula(String nombreIdAula) {
        this.nombreIdAula = nombreIdAula;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getNombreIdHorario() {
        return nombreIdHorario;
    }

    public void setNombreIdHorario(String nombreIdHorario) {
        this.nombreIdHorario = nombreIdHorario;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreIdGrupo() {
        return nombreIdGrupo;
    }

    public void setNombreIdGrupo(String nombreIdGrupo) {
        this.nombreIdGrupo = nombreIdGrupo;
    }

    public String getNombreIdfp() {
        return nombreIdfp;
    }

    public void setNombreIdfp(String nombreIdfp) {
        this.nombreIdfp = nombreIdfp;
    }
}

