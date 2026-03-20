package com.bn.categoriacs.services;

import com.bn.categoriacs.models.CategoriaModel;
import com.bn.categoriacs.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaModel criar(CategoriaModel categoriaModel) {
        return categoriaRepository.save(categoriaModel);
    }

    public CategoriaModel procurarPorId(Long id) {
        return categoriaRepository.findById(id).get();
    }

    public List<CategoriaModel> listar() {
        return categoriaRepository.findAll();
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
