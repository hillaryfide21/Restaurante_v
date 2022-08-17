package com.restaurante.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurantes")
public class Restaurantes implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String horario="10:00am-9:00pm";
    private String correo;
    private String maps;
    
    @JoinColumn(name = "id_horario")
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private horario_reservas id_horario; /*fk*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public horario_reservas getId_horario() {
        return id_horario;
    }

    public void setId_horario(horario_reservas id_horario) {
        this.id_horario = id_horario;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }   
}


/*

https://maps.googleapis.com/maps/api/staticmap?center=9.935313,-84.091444&zoom=17&size=150x150&markers=size:tiny,color:red%7Clabel:P%7C9.935313,-84.091444&key=AIzaSyCdLq97MS66icDg_4s3nCVRlWrcbvndKa0

*/