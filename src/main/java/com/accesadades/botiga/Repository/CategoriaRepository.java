package com.accesadades.botiga.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.accesadades.botiga.Model.Categoria;

@Repository
// Defineix la interfície del repositori per a la classe Categoria
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    // Declara un metode per trobar una Categoria pel seu nom
    Categoria findByName(String name);
}
