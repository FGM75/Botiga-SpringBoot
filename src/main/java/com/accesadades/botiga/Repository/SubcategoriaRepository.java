package com.accesadades.botiga.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.accesadades.botiga.Model.Subcategoria;

@Repository
public interface SubcategoriaRepository extends CrudRepository<Subcategoria, Long> {
    Subcategoria findByName(String name);
}
