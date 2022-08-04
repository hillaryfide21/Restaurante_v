package com.restaurante.service;

import com.restaurante.entity.Categorias;
import com.restaurante.entity.Menu;
import com.restaurante.repository.MenuRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService implements IMenuService{
    
    @Autowired
    private MenuRepository menuRepository;
    
    @Override
    public List<Menu> getAllData() {
        return(List<Menu>) menuRepository.findAll();
    }

    @Override
    public Optional<Menu> getDataById(long id_producto) {
        return menuRepository.findById(id_producto);
    }

    @Override
    public void saveInformacion(Menu registro) {
        menuRepository.save(registro);
    }

    @Override
    public void delete(long id_producto) {
        menuRepository.deleteById(id_producto);
    }

    @Override
    public List<Menu> findAll(Categorias categoria_producto) {
            return menuRepository.findAll(categoria_producto);
    }

}
