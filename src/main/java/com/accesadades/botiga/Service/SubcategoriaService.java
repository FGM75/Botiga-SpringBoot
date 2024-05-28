package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Subcategoria;

public interface SubcategoriaService {
    Subcategoria findByName(String name);
    void save(Subcategoria subcategoria);
}
