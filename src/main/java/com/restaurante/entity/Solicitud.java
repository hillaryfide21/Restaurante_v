/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author XPC
 */
@Entity
@Table(name="solicitudes")
public class Solicitud implements Serializable{
    @Id 
    @GeneratedValue (strategy= GenerationType.IDENTITY) 
    private long id_solicitud; /*se tiene que cambiar por DATE*/
    private String cedula;
    private String nombre;
    private String correo;
    private String cv;
    
    @ManyToOne
    @JoinColumn(name = "id_puesto")
    
    private Puesto puesto;

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
  

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public long getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(long id_solicitud) {
        this.id_solicitud = id_solicitud;
    }
    
    
}
