package com.accesadades.botiga.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.accesadades.botiga.Model.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    Categoria findByName(String name);
}
