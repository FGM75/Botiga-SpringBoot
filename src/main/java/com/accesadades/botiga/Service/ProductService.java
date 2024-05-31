package com.accesadades.botiga.Service;

import java.util.Set;
import com.accesadades.botiga.Model.Product;

public interface ProductService {
 
    // Declara un mètode per trobar tots els Product
    Set<Product> findAllProducts();

    // Declara un mètode per trobar un Product pel seu nom
    Product findProductsByName(String name);

    // Declara un mètode per trobar tots els Product d'una subcategoria específica
    Set<Product> findAllProducts(String subcategory);

    // Declara un mètode per guardar un Product
    void save(Product product);

    // Declara un mètode per augmentar el preu d'un Product
    void increasePrice(Product product);
}