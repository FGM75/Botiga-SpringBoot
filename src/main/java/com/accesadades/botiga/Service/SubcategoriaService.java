package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Subcategoria;

public interface SubcategoriaService {
    // Troba subcategoria pel nom
    Subcategoria findByName(String name);

    // Guarda una subcategoria
    void save(Subcategoria subcategoria);
}