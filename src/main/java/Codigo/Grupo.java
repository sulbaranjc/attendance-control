/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

public class Grupo {
    private int id;
    private String nombre;
    private int idPeriodo;
    private int idFp;
    private int idTurno;
    private int idModalidad;
    private int idGrupoAlumno;
    private String nombrePeriodoId;
    private String nombreFpId;
    private String nombreTurnoId;
    private String nombreModalidadId;

    public Grupo() {
    }

    public Grupo(int id, String nombre, int idPeriodo, int idFp, int idTurno, int idModalidad, int idGrupoAlumno, String nombrePeriodoId, String nombreFpId, String nombreTurnoId, String nombreModalidadId) {
        this.id = id;
        this.nombre = nombre;
        this.idPeriodo = idPeriodo;
        this.idFp = idFp;
        this.idTurno = idTurno;
        this.idModalidad = idModalidad;
        this.idGrupoAlumno = idGrupoAlumno;
        this.nombrePeriodoId = nombrePeriodoId;
        this.nombreFpId = nombreFpId;
        this.nombreTurnoId = nombreTurnoId;
        this.nombreModalidadId = nombreModalidadId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public int getIdFp() {
        return idFp;
    }

    public void setIdFp(int idFp) {
        this.idFp = idFp;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public int getIdGrupoAlumno() {
        return idGrupoAlumno;
    }

    public void setIdGrupoAlumno(int idGrupoAlumno) {
        this.idGrupoAlumno = idGrupoAlumno;
    }

    public String getNombrePeriodoId() {
        return nombrePeriodoId;
    }

    public void setNombrePeriodoId(String nombrePeriodoId) {
        this.nombrePeriodoId = nombrePeriodoId;
    }

    public String getNombreFpId() {
        return nombreFpId;
    }

    public void setNombreFpId(String nombreFpId) {
        this.nombreFpId = nombreFpId;
    }

    public String getNombreTurnoId() {
        return nombreTurnoId;
    }

    public void setNombreTurnoId(String nombreTurnoId) {
        this.nombreTurnoId = nombreTurnoId;
    }

    public String getNombreModalidadId() {
        return nombreModalidadId;
    }

    public void setNombreModalidadId(String nombreModalidadId) {
        this.nombreModalidadId = nombreModalidadId;
    }
}
