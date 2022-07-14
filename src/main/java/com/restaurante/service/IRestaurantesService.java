package com.restaurante.service;

import com.restaurante.entity.Restaurantes;
import java.util.List;

public interface IRestaurantesService {
    public List<Restaurantes> getAllData();
    public Restaurantes getDataById (long id_restaurante);
    public void saveInformacion(Restaurantes registro);
    public void delete(long id_restaurante);
}
