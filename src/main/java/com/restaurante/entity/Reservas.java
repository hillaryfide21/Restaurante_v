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
 * @author Marvin Camacho
 */
@Entity
@Table(name = "reservas")
public class Reservas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_reserva;
    /*pk*/
    private String fecha_reserva;
    private String nombre_reserva;
    private String telefono_reserva;;
    

    @JoinColumn(name = "id_restaurante")
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Restaurantes id_restaurante; /*fk*/

    public long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getNombre_reserva() {
        return nombre_reserva;
    }

    public void setNombre_reserva(String nombre_reserva) {
        this.nombre_reserva = nombre_reserva;
    }

    public String getTelefono_reserva() {
        return telefono_reserva;
    }

    public void setTelefono_reserva(String telefono_reserva) {
        this.telefono_reserva = telefono_reserva;
    }

    public Restaurantes getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(Restaurantes id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

}
