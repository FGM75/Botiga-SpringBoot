package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.Repository.SubcategoriaRepository;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Override
    public Set<Subcategoria> findAllSubcategorias() {
        return (Set<Subcategoria>) subcategoriaRepository.findAll();
    }

    @Override
    public Subcategoria findByName(String name) {
        return subcategoriaRepository.findByName(name);
    }
}
