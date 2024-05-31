package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.Repository.SubcategoriaRepository;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    // Troba subcategoria pel nom
    @Override
    public Subcategoria findByName(String name) {
        return subcategoriaRepository.findByName(name);
    }

    // Guarda una subcategoria
    @Override
    public void save(Subcategoria subcategoria) {
        subcategoriaRepository.save(subcategoria);
    }
}
