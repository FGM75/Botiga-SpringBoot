package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Troba tots els productes
    @Override
    public Set<Product> findAllProducts() {
        return productRepository.findAll();
    }

    // Troba productes per subcategoria (no implementat)
    @Override
    public Set<Product> findAllProducts(String subcategory) {
        return null;
    }

    // Troba producte pel nom
    @Override
    public Product findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    // Guarda un producte
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    // Augmenta el preu d'un producte
    @Override
    public void increasePrice(Product product) {
        if (product != null) {
            float increasePercentage = 0.10f; // 10% d'augment
            float newPrice = product.getPrice() * (1 + increasePercentage);
            product.setPrice(newPrice);
            productRepository.save(product);
        }
    }
}
