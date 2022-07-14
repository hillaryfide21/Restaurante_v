package com.restaurante.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurantes")

public class Restaurantes implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    private long id_restaurante;
    private String restaurante;
    private String direccion_restaurante;
    private String telefono_restaurante;
    private String horario_LV;
    private String horario_S;
    private String correo_restaurante;

    public long getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(long id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public String getDireccion_restaurante() {
        return direccion_restaurante;
    }

    public void setDireccion_restaurante(String direccion_restaurante) {
        this.direccion_restaurante = direccion_restaurante;
    }

    public String getTelefono_restaurante() {
        return telefono_restaurante;
    }

    public void setTelefono_restaurante(String telefono_restaurante) {
        this.telefono_restaurante = telefono_restaurante;
    }

    public String getHorario_LV() {
        return horario_LV;
    }

    public void setHorario_LV(String horario_LV) {
        this.horario_LV = horario_LV;
    }

    public String getHorario_S() {
        return horario_S;
    }

    public void setHorario_S(String horario_S) {
        this.horario_S = horario_S;
    }

    public String getCorreo_restaurante() {
        return correo_restaurante;
    }

    public void setCorreo_restaurante(String correo_restaurante) {
        this.correo_restaurante = correo_restaurante;
    }
        
    
}
