/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;
public class Asignatura {
    private int id;
    private String nombre;
    private int fpId;
    private String nombreFpId;

    public Asignatura() {
    }

    public Asignatura(int id, String nombre, int fpId, String nombreFpId) {
        this.id = id;
        this.nombre = nombre;
        this.fpId = fpId;
        this.nombreFpId = nombreFpId;
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

    public int getFpId() {
        return fpId;
    }

    public void setFpId(int fpId) {
        this.fpId = fpId;
    }

    public String getNombreFpId() {
        return nombreFpId;
    }

    public void setNombreFpId(String nombreFpId) {
        this.nombreFpId = nombreFpId;
    }
}
