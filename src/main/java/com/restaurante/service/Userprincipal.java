/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Usuarios;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Sky
 */
    public class Userprincipal  implements UserDetails{
    private Usuarios usuarios;
 
    
    public Userprincipal(Usuarios usuarios){
    this.usuarios=usuarios;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        /*extract list of permissions(name)*/
        this.usuarios.getPermissionList().forEach(p ->{
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
                
        });
      
           /*extract list of roles(Role_name)*/
        this.usuarios.getRoleList().forEach(r ->{
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+ r);
            authorities.add(authority);
                
        });
        return authorities;
    }
    

    @Override
    public String getPassword() {
        return this.usuarios.getContrasena_usuario();
    }

    @Override
    public String getUsername() {
     return this.usuarios.getNombre_usuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true ;
    }

    @Override
    public boolean isAccountNonLocked() {
return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    return true;
    }

    @Override
    public boolean isEnabled() {
    return this.usuarios.getActive() ==1;
    }
    
    
}
