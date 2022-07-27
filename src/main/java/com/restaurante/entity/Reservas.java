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
    private String dia_reserva;
    private int cantidad_reserva;
    private String hora_reserva;
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
    public String getDia_reserva() {
        return dia_reserva;
    }

    public void setDia_reserva(String dia_reserva) {
        this.dia_reserva = dia_reserva;
    }

    public String getHora_reserva() {
        return hora_reserva;
    }

    public void setHora_reserva(String hora_reserva) {
        this.hora_reserva = hora_reserva;
    }

    public int getCantidad_reserva() {
        return cantidad_reserva;
    }

    public void setCantidad_reserva(int cantidad_reserva) {
        this.cantidad_reserva = cantidad_reserva;
    }
    
}
