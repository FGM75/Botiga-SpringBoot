package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.accesadades.botiga.Model.*;
import com.accesadades.botiga.Service.*;

import java.util.Set;

@Controller
public class WebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private SubcategoriaService subcategoriaService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/catalog")
    public String catalog(Model model) {
        Set<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "catalog";
    }

    @RequestMapping(value = {"/search", "/prodname"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            Product product = productService.findProductsByName(name);
            model.addAttribute("product", product);
        }
        return "search"; // Referencia a search.html en el directorio templates
    }

    @GetMapping("/productes/desar")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/productes/desar")
    public String saveProduct(@RequestParam String nom,
                              @RequestParam String descripcio,
                              @RequestParam long unitats,
                              @RequestParam float preu,
                              @RequestParam String fabricant,
                              @RequestParam String subcategoria,
                              @RequestParam String categoria,
                              Model model) {

        // Verifica si la categoría existe
        Categoria existingCategory = categoriaService.findByName(categoria);
        if (existingCategory == null) {
            // Crea una nueva categoría si no existe
            existingCategory = new Categoria();
            existingCategory.setName(categoria);
            categoriaService.save(existingCategory);
        }

        // Verifica si la subcategoría existe y pertenece a la categoría dada
        Subcategoria existingSubcategory = subcategoriaService.findByName(subcategoria);
        if (existingSubcategory == null) {
            // Crea una nueva subcategoría si no existe
            existingSubcategory = new Subcategoria();
            existingSubcategory.setName(subcategoria);
            existingSubcategory.setCategoria(existingCategory);
            subcategoriaService.save(existingSubcategory);
        } else if (!existingSubcategory.getCategoria().getName().equals(categoria)) {
            // Si la subcategoría no corresponde a la categoría, lanza un error
            model.addAttribute("error", "La subcategoría no corresponde a la categoría dada.");
            return "product";
        }

        // Crea y guarda el nuevo producto
        Product product = new Product();
        product.setName(nom);
        product.setDescription(descripcio);
        product.setUnits(unitats);
        product.setPrice(preu);
        product.setCompany(fabricant);
        productService.save(product);

        return "redirect:/catalog";
    }
}
