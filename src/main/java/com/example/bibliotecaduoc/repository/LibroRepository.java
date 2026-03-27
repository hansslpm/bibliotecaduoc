package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {
    
    private List<Libro> listaLibros;

    public LibroRepository() {
        listaLibros = new ArrayList<>();
    }

    public List<Libro> readAll() {
        return listaLibros;
    }

    public Libro save(Libro libro) {
        listaLibros.add(libro);
        return libro;
    }


}

