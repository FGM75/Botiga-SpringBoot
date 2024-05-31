package com.accesadades.botiga.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.accesadades.botiga.Model.Subcategoria;

@Repository
// Defineix la interfície del repositori per a la classe Subcategoria
public interface SubcategoriaRepository extends CrudRepository<Subcategoria, Long> {
    //Metode per trobar una Subcategoria pel seu nom
    Subcategoria findByName(String name);
}
