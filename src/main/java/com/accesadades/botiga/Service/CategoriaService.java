package com.accesadades.botiga.Service;

import java.util.Set;
import com.accesadades.botiga.Model.Categoria;

public interface CategoriaService {
    Set<Categoria> findAllCategorias();
    Categoria findByName(String name);
}
