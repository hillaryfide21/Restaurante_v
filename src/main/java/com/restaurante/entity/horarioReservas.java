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
import javax.persistence.Table;

/**
 *
 * @author Marvin Camacho
 */
@Entity
@Table(name = "horarioReservas")
public class horarioReservas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_reserva_horario;
    
    private boolean horario1;
    private boolean horario2;
    private boolean horario3;
    private boolean horario4;
    private boolean horario5;
    private boolean horario6;
    
    private int horario1Cant;
    private int horario2Cant;
    private int horario3Cant;
    private int horario4Cant;
    private int horario5Cant;
    private int horario6Cant;

    public long getId_reserva_horario() {
        return id_reserva_horario;
    }

    public void setId_reserva_horario(long id_reserva_horario) {
        this.id_reserva_horario = id_reserva_horario;
    }

    public boolean isHorario1() {
        return horario1;
    }

    public void setHorario1(boolean horario1) {
        this.horario1 = horario1;
    }

    public boolean isHorario2() {
        return horario2;
    }

    public void setHorario2(boolean horario2) {
        this.horario2 = horario2;
    }

    public boolean isHorario3() {
        return horario3;
    }

    public void setHorario3(boolean horario3) {
        this.horario3 = horario3;
    }

    public boolean isHorario4() {
        return horario4;
    }

    public void setHorario4(boolean horario4) {
        this.horario4 = horario4;
    }

    public boolean isHorario5() {
        return horario5;
    }

    public void setHorario5(boolean horario5) {
        this.horario5 = horario5;
    }

    public boolean isHorario6() {
        return horario6;
    }

    public void setHorario6(boolean horario6) {
        this.horario6 = horario6;
    }

    public int getHorario1Cant() {
        return horario1Cant;
    }

    public void setHorario1Cant(int horario1Cant) {
        this.horario1Cant = horario1Cant;
    }

    public int getHorario2Cant() {
        return horario2Cant;
    }

    public void setHorario2Cant(int horario2Cant) {
        this.horario2Cant = horario2Cant;
    }

    public int getHorario3Cant() {
        return horario3Cant;
    }

    public void setHorario3Cant(int horario3Cant) {
        this.horario3Cant = horario3Cant;
    }

    public int getHorario4Cant() {
        return horario4Cant;
    }

    public void setHorario4Cant(int horario4Cant) {
        this.horario4Cant = horario4Cant;
    }

    public int getHorario5Cant() {
        return horario5Cant;
    }

    public void setHorario5Cant(int horario5Cant) {
        this.horario5Cant = horario5Cant;
    }

    public int getHorario6Cant() {
        return horario6Cant;
    }

    public void setHorario6Cant(int horario6Cant) {
        this.horario6Cant = horario6Cant;
    }
    
    public int getEspaciosTotal(){
        return horario1Cant+horario2Cant+horario3Cant+horario4Cant+horario5Cant+horario6Cant;
    }
    
}
