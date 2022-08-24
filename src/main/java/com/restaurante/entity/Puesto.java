/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.entity;

import java.io.Serializable;
import javax.persistence.Entity;
//import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Hillary
 */
@Entity
@Table(name="puestos")
public class Puesto implements Serializable{
    @Id 
    @GeneratedValue (strategy= GenerationType.IDENTITY)  
    
    private long id_puesto;
    private String nombre_puesto;
    private String detalle_puesto;
    private String requisito_puesto;
    

    public long getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(long id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getNombre_puesto() {
        return nombre_puesto;
    }

    public void setNombre_puesto(String nombre_puesto) {
        this.nombre_puesto = nombre_puesto;
    }

    public String getDetalle_puesto() {
        return detalle_puesto;
    }

    public void setDetalle_puesto(String detalle_puesto) {
        this.detalle_puesto = detalle_puesto;
    }

    public String getRequisito_puesto() {
        return requisito_puesto;
    }

    public void setRequisito_puesto(String requisito_puesto) {
        this.requisito_puesto = requisito_puesto;
    }


}

