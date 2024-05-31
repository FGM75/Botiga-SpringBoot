package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.accesadades.botiga.Model.*;
import com.accesadades.botiga.Service.*;

import java.util.Set;

@Controller // Marca aquesta classe com un controlador de Spring MVC
public class WebController {

    @Autowired // Dependencies ProductService, CategoriaService, i SubcategoriaService
    private ProductService productService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private SubcategoriaService subcategoriaService;

    @RequestMapping(value = "/") // Gestiona les peticions a la ruta arrel
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/catalog") // Gestiona les peticions a la ruta "/catalog"
    public String catalog(Model model) {
        Set<Product> products = productService.findAllProducts(); // Agafa tots els productes
        model.addAttribute("products", products); // Afegeix els productes al model
        return "catalog";
    }

    @RequestMapping(value = {"/search", "/prodname"}, method = {RequestMethod.GET, RequestMethod.POST}) // Gestiona peticions GET i POST a les rutes "/search" i "/prodname"
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            Product product = productService.findProductsByName(name); // Cerca un producte pel seu nom
            model.addAttribute("product", product); // Afegeix el producte al model
        }
        return "search";
    }

    @GetMapping("/productes/desar") // Gestiona peticions GET a la ruta "/productes/desar"
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product()); // Afegeix un nou objecte Product al model
        return "product"; // Retorna la vista "product.html"
    }

    @PostMapping("/productes/desar") // Gestiona peticions POST a la ruta "/productes/desar"
    public String saveProduct(@RequestParam String nom,
                              @RequestParam String descripcio,
                              @RequestParam long unitats,
                              @RequestParam float preu,
                              @RequestParam String fabricant,
                              @RequestParam String subcategoria,
                              @RequestParam String categoria,
                              Model model) {

        // Verifica si la categoria existeix
        Categoria existingCategory = categoriaService.findByName(categoria);
        if (existingCategory == null) {
            // Crea una nova categoria si no existeix
            existingCategory = new Categoria();
            existingCategory.setName(categoria);
            categoriaService.save(existingCategory);
        }

        // Verifica si la subcategoria existeix i pertany a la categoria donada
        Subcategoria existingSubcategory = subcategoriaService.findByName(subcategoria);
        if (existingSubcategory == null) {
            // Crea una nova subcategoria si no existeix
            existingSubcategory = new Subcategoria();
            existingSubcategory.setName(subcategoria);
            existingSubcategory.setCategoria(existingCategory);
            subcategoriaService.save(existingSubcategory);
        } else if (!existingSubcategory.getCategoria().getName().equals(categoria)) {
            // Si la subcategoria no correspon a la categoria dona error
            model.addAttribute("error", "La subcategoria no correspon a la categoria donada.");
            return "product";
        }

        // Crea i guarda el nou producte
        Product product = new Product();
        product.setName(nom);
        product.setDescription(descripcio);
        product.setUnits(unitats);
        product.setPrice(preu);
        product.setCompany(fabricant);
        productService.save(product);

        return "redirect:/catalog"; // Redirigeix a la pàgina del catàleg
    }
}
