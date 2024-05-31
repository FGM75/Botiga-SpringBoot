package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    // Injecció de dependència del repositori CategoriaRepository
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Implementa el metode findByName per trobar una Categoria pel seu nom
    @Override
    public Categoria findByName(String name) {
        return categoriaRepository.findByName(name);
    }

    // Metode save per guardar una Categoria
    @Override
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
}
