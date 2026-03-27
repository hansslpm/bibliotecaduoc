package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// @Controller -> Pagina web
// @RestController -> Api rest
@RestController
@RequestMapping("/api/v1/libros") 
// @RequestMapping("/api/v1/libros")  -> Direccion api, se incluye version por buena practica, por si en un futuro se cambia
// esa version siga funcionando. Asi no rompemos aplicaciones de terceros o quiza propias.

public class LibroController {

    // inyeccion de dependencias con @Autowired, explicacion en la clase LibroRepository
    @Autowired
    private LibroService libroService;

    // Buena practica: Que los metodos se llamen similar al @GetMapping, @PostMapping, etc.
    @GetMapping()
    public List<Libro> getLibros() {
        return libroService.readAll();
    }

    @PostMapping()
    public Libro postLibro(@RequestBody Libro libro) {
        return libroService.create(libro);
    }
    
    
    
}
