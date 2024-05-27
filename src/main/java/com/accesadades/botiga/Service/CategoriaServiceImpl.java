package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Set<Categoria> findAllCategorias() {
        return (Set<Categoria>) categoriaRepository.findAll();
    }

    @Override
    public Categoria findByName(String name) {
        return categoriaRepository.findByName(name);
    }
}
