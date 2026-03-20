package com.bn.categoriacs.controllers;

import com.bn.categoriacs.models.CategoriaModel;
import com.bn.categoriacs.repositories.CategoriaRepository;
import com.bn.categoriacs.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaModel> salvar(@RequestBody CategoriaModel categoriaModel) {
        CategoriaModel request = categoriaService.criar(categoriaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/categorias/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> listar() {
        List<CategoriaModel> request = categoriaService.listar();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> procurarPorId(@PathVariable Long id) {
        CategoriaModel request = categoriaService.procurarPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
