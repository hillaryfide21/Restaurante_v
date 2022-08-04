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
    
    private long id_restaurante;
    private String nombre_restaurante;
    private String direccion_restaurante;
    private String telefono_restaurante;
    private String horario_restaurante;
    private String correo_restaurante;
    
    @JoinColumn(name = "id_reserva_horario")
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private horarioReservas id_reserva_horario; /*fk*/
    

    public horarioReservas getId_reserva_horario() {
        return id_reserva_horario;
    }

    public void setId_reserva_horario(horarioReservas id_reserva_horario) {
        this.id_reserva_horario = id_reserva_horario;
    }
    
    public long getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(long id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public String getRestaurante() {
        return nombre_restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.nombre_restaurante = restaurante;
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

    public String getCorreo_restaurante() {
        return correo_restaurante;
    }

    public void setCorreo_restaurante(String correo_restaurante) {
        this.correo_restaurante = correo_restaurante;
    }
        public String getNombre_restaurante() {
        return nombre_restaurante;
    }

    public void setNombre_restaurante(String nombre_restaurante) {
        this.nombre_restaurante = nombre_restaurante;
    }

    public String getHorario_restaurante() {
        return horario_restaurante;
    }

    public void setHorario_restaurante(String horario_restaurante) {
        this.horario_restaurante = horario_restaurante;
    }
    
}
