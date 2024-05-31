package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Categoria;

// Defineix la interfície del servei per a la classe Categoria
public interface CategoriaService {
    // Metode per trobar una Categoria pel seu nom
    Categoria findByName(String name);

    // Metode per guardar una Categoria
    void save(Categoria categoria);
}
