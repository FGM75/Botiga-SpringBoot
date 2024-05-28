package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Categoria;

public interface CategoriaService {
    Categoria findByName(String name);
    void save(Categoria categoria);
}
