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

/**
 *
 * @author XPC
 */
/*DB es Contactenos*/
@Entity
public class Contacto implements Serializable{
    @Id 
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    long id_contactenos;
    String fecha_contactenos; /*se tiene q cambiar por tipo date y se tiene q quitar de crearContact.html*/
    String nombre_contactenos;
    String telefono_contactenos;
    String correo_contactenos;
    String asunto_contactenos;
    String mensaje_contactenos;

    public long getId_contactenos() {
        return id_contactenos;
    }

    public void setId_contactenos(long id_contactenos) {
        this.id_contactenos = id_contactenos;
    }

    public String getFecha_contactenos() {
        return fecha_contactenos;
    }

    public void setFecha_contactenos(String fecha_contactenos) {
        this.fecha_contactenos = fecha_contactenos;
    }

    public String getNombre_contactenos() {
        return nombre_contactenos;
    }

    public void setNombre_contactenos(String nombre_contactenos) {
        this.nombre_contactenos = nombre_contactenos;
    }

    public String getTelefono_contactenos() {
        return telefono_contactenos;
    }

    public void setTelefono_contactenos(String telefono_contactenos) {
        this.telefono_contactenos = telefono_contactenos;
    }

    public String getCorreo_contactenos() {
        return correo_contactenos;
    }

    public void setCorreo_contactenos(String correo_contactenos) {
        this.correo_contactenos = correo_contactenos;
    }

    public String getAsunto_contactenos() {
        return asunto_contactenos;
    }

    public void setAsunto_contactenos(String asunto_contactenos) {
        this.asunto_contactenos = asunto_contactenos;
    }

    public String getMensaje_contactenos() {
        return mensaje_contactenos;
    }

    public void setMensaje_contactenos(String mensaje_contactenos) {
        this.mensaje_contactenos = mensaje_contactenos;
    }
    
    
}
