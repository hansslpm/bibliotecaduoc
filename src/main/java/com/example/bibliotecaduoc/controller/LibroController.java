package com.example.bibliotecaduoc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




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
    
    // fake data -> comun
    @GetMapping("seed")
    public String getSeed() {
        libroService.fakeData();
        return "Datos cargados";
    }

    @GetMapping("id/{id}")
    public Optional<Libro> getLibroId(@PathVariable int id) {
        return libroService.readById(id);
    }
    
    @GetMapping("isbn/{isbn}")
    public Optional<Libro> getLibroIsbn(@PathVariable String isbn) {
        return libroService.readByIsbn(isbn);
    }
    
    @PutMapping("{id}")
    public Libro putLibroId(@PathVariable int id, @RequestBody Libro libro) {
        return libroService.updateLibro(id, libro);
    }

    @DeleteMapping("delete/{id}")
    public String deleteId(@PathVariable int id) {
        if(libroService.deleteLibro(id)) {
            return "Libro eliminado";
        }
        return "El libro con " + id + " id no se pudo eliminar ya que no existe en los registros.";
    }

}
