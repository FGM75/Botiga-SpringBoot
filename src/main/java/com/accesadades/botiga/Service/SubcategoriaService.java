package com.accesadades.botiga.Service;

import java.util.Set;
import com.accesadades.botiga.Model.Subcategoria;

public interface SubcategoriaService {
    Set<Subcategoria> findAllSubcategorias();
    Subcategoria findByName(String name);
}
