package com.example.bibliotecaduoc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

//@Service indica que esta clase es un service
@Service
public class LibroService {

    // Hacer la conexion con LibroRepository con @Autowired

    /*
    La anotación @Autowired en Spring Boot permite inyectar dependencias automáticamente,
    eliminando la necesidad de crear objetos manualmente con new.
    Spring busca beans (componentes) compatibles en su contenedor y los enlaza,
    lo que reduce código repetitivo, facilita el testing y mejora la mantenibilidad al desacoplar componentes.
    */

    /*
 * INYECCIÓN DE DEPENDENCIAS (DI)
 * ---------------------------------------------------------
 * ¿Qué es?: Es "recibir" los objetos que necesito en lugar de "crearlos" yo mismo.
 * * Regla de Oro: No uses 'new Clase()' dentro de esta clase para sus herramientas.
 * Por qué: Si esta clase recibe sus dependencias por el constructor, se vuelve
 * desacoplada, fácil de testear y flexible a cambios futuros.
 * * "No fabriques tus herramientas, espera a que te las entreguen".
 */

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> readAll() {
        return libroRepository.readAll();
    }

    public Libro create(Libro libro) {
        return libroRepository.save(libro);
    }

    public void fakeData() {
        libroRepository.fakeData();
    }

    public Optional<Libro> readById(int id) {
        return libroRepository.readById(id);
    }

    public Optional<Libro> readByIsbn(String isbn) {
        return libroRepository.readByIsbn(isbn);
    }

    public Libro updateLibro(int id, Libro libro) {
        return libroRepository.updateLibro(id, libro);
    }

    public boolean deleteLibro(int id) {
        return libroRepository.deleteLibro(id);
    }
    
}
