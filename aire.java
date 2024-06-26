/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.beam.examples;

/**
 *
 * @author leo
 */
public class Recorrido {

    private String id;
    private String codigo;
    private String nombre;
    private String idaId;
    private String horariosTipoDia;
    private String horariosInicio;
    private String horariosFin;
    private String path;
    private String negocioId;
    private String negocioNombre;
    private String negocioColor;
    private String negocioUrl;

    public Recorrido() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdaId() {
        return idaId;
    }

    public void setIdaId(String idaId) {
        this.idaId = idaId;
    }

    public String getHorariosTipoDia() {
        return horariosTipoDia;
    }

    public void setHorariosTipoDia(String horariosTipoDia) {
        this.horariosTipoDia = horariosTipoDia;
    }

    public String getHorariosInicio() {
        return horariosInicio;
    }

    public void setHorariosInicio(String horariosInicio) {
        this.horariosInicio = horariosInicio;
    }

    public String getHorariosFin() {
        return horariosFin;
    }

    public void setHorariosFin(String horariosFin) {
        this.horariosFin = horariosFin;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNegocioId() {
        return negocioId;
    }

    public void setNegocioId(String negocioId) {
        this.negocioId = negocioId;
    }

    public String getNegocioNombre() {
        return negocioNombre;
    }

    public void setNegocioNombre(String negocioNombre) {
        this.negocioNombre = negocioNombre;
    }

    public String getNegocioColor() {
        return negocioColor;
    }

    public void setNegocioColor(String negocioColor) {
        this.negocioColor = negocioColor;
    }

    public String getNegocioUrl() {
        return negocioUrl;
    }

    public void setNegocioUrl(String negocioUrl) {
        this.negocioUrl = negocioUrl;
    }

    @Override
    public String toString() {
        return "Recorrido{" +
                "id='" + id + '\'' +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", idaId='" + idaId + '\'' +
                ", horariosTipoDia='" + horariosTipoDia + '\'' +
                ", horariosInicio='" + horariosInicio + '\'' +
                ", horariosFin='" + horariosFin + '\'' +
                ", path='" + path + '\'' +
                ", negocioId='" + negocioId + '\'' +
                ", negocioNombre='" + negocioNombre + '\'' +
                ", negocioColor='" + negocioColor + '\'' +
                ", negocioUrl='" + negocioUrl + '\'' +
                '}';
    }

    public String toCSV() {
        return id + "," + codigo + "," + nombre + "," + idaId + "," + horariosTipoDia + "," + horariosInicio + "," + horariosFin + "," + path + "," +
                negocioId + "," + negocioNombre + "," + negocioColor + "," + negocioUrl;
    }

}
