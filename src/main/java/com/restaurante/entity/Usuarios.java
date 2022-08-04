/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Sky
 */
@Entity
@Table(name= "usuarios")
public class Usuarios implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;
    
       private String nombre_usuario;
       private String apellido1_usuario;
       private String apellido2_usuario;
       private String dirección_usuario;
       private String telefono_usuario;
       private String correo_usuario;
       
       /*UTILIZADO PARA EL LOGIN*/
       
       private String contrasena_usuario;
         private int active;
         private String roles="";
         private String permissions="";
        /*login */       

       
      @JoinColumn (name="id_rol")
      @OneToOne
      @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Roles id_rol;

      /*Login*/

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
     
    public List<String> getRoleList(){
    if (this.roles.length() > 0){
    return Arrays.asList(this.roles.split(","));
    }
    return new ArrayList<>();
    }
    
        public List<String> getPermissionList(){
    if (this.permissions.length() > 0){
    return Arrays.asList(this.permissions.split(","));
    }
    return new ArrayList<>();
    }
        
         /*Login end*/
    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido1_usuario() {
        return apellido1_usuario;
    }

    public void setApellido1_usuario(String apellido1_usuario) {
        this.apellido1_usuario = apellido1_usuario;
    }

    public String getApellido2_usuario() {
        return apellido2_usuario;
    }

    public void setApellido2_usuario(String apellido2_usuario) {
        this.apellido2_usuario = apellido2_usuario;
    }

    public String getDireccion_usuario() {
        return dirección_usuario;
    }

    public void setDirección_usuario(String dirección_usuario) {
        this.dirección_usuario = dirección_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }

    public Roles getId_rol() {
        return id_rol;
    }

    public void setId_rol(Roles id_rol) {
        this.id_rol = id_rol;
    }    
 
    
}
