package com.restaurante.service;

import java.util.Optional;
import com.restaurante.entity.Categorias;
import com.restaurante.entity.Menu;
import java.util.List;

public interface IMenuService {
    public List<Menu> getAllData();
    public Optional<Menu> getDataById (long id_producto);
    public void saveInformacion(Menu registro);
    public void delete(long id_producto);
    public List<Menu> findAll(Categorias categoria_producto);
}
