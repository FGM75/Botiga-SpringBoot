package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.Service.ProductService;
import com.accesadades.botiga.Service.CategoriaService;
import com.accesadades.botiga.Service.SubcategoriaService;

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
        return "search";
    }

    @GetMapping("/productes/nou")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("subcategories", subcategoriaService.findAllSubcategorias());
        model.addAttribute("categories", categoriaService.findAllCategorias());
        return "product_form";
    }

    @PostMapping("/productes/desar")
    public String saveProduct(@ModelAttribute Product product, @RequestParam String subcategoria, @RequestParam String categoria) {
        Subcategoria subcat = subcategoriaService.findByName(subcategoria);
        Categoria cat = categoriaService.findByName(categoria);
        if (subcat == null || cat == null || !subcat.getCategoria().equals(cat)) {
            return "error";
        }
        product.setSubcategory(subcat);
        productService.save(product);
        return "redirect:/";
    }
}
