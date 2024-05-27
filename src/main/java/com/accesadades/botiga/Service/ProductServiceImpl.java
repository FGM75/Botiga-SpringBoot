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

    @Override
    public Set<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Set<Product> findAllProducts(String subcategory) {
        return null;
    }

    @Override
    public Product findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void increasePrice(Product product) {
        if (product != null) {
            // Define el porcentaje de aumento. Por ejemplo, un 10% de aumento.
            float increasePercentage = 0.10f;
            
            // Calcula el nuevo precio.
            float newPrice = product.getPrice() * (1 + increasePercentage);
            
            // Actualiza el precio del producto.
            product.setPrice(newPrice);
            
            // Guarda el producto actualizado en la base de datos.
            productRepository.save(product);
        }
    }
}
