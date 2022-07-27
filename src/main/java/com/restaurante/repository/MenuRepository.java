package com.restaurante.repository;

import com.restaurante.entity.Categorias;
import com.restaurante.entity.Menu;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> /*extends JpaRepository<Menu, Long>*/{
    @Query ("SELECT p from Menu p WHERE p.id_categoria LIKE ?1")
    public List<Menu> findAll(Categorias id_categoria);

}
