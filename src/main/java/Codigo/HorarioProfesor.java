package Codigo;

public class HorarioProfesor {
    private String horario;
    private String lunes;
    private String martes;
    private String miercoles;
    private String jueves;
    private String viernes;

    // Constructor
    public HorarioProfesor(String horario, String lunes, String martes, String miercoles, String jueves, String viernes) {
        this.horario = horario;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
    }

    // Getters y Setters
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    @Override
    public String toString() {
        return "HorarioProfesor{" +
                "horario='" + horario + '\'' +
                ", lunes='" + lunes + '\'' +
                ", martes='" + martes + '\'' +
                ", miercoles='" + miercoles + '\'' +
                ", jueves='" + jueves + '\'' +
                ", viernes='" + viernes + '\'' +
                '}';
    }
}
