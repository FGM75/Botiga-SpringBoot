package com.accesadades.botiga.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.Set;
import com.accesadades.botiga.Model.Product;

@Repository
// Defineix la interfície del repositori per a la classe Product
public interface ProductRepository extends CrudRepository<Product, Long> {

    // Metode per retornar un conjunt de productes
    @Override
    @NonNull
    Set<Product> findAll();

    // Metode per trobar un product pel seu nom
    Product findByName(String name);

    // Metode per trobar product per nom i preu
    Set<Product> findByNameAndPrice(String name, float price);
}