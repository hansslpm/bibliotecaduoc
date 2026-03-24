package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {
    
    private List<Libro> listaLibros;

    public LibroRepository() {
        listaLibros = new ArrayList<>();
    }


    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    public Libro agregarLibro(Libro libro) {
        listaLibros.add(libro);
        return libro;
    }


    // VERIFICAR EN CASA CUANDO EL LIBRO NO SE ENCUENTRA, DEVOLVER NULO EN VEZ DE Opcional.isEmpty()
    public Optional<Libro> buscarPorId(int id) {
            return listaLibros.stream().filter(libro -> libro.getId() == id).findFirst();
        }

    public Optional<Libro> buscarPorIsbn(String isbn) {
            return listaLibros.stream().filter(libro -> libro.getIsbn().equalsIgnoreCase(isbn)).findFirst();
        }

    public Libro actualizar(Libro nuevoLibro) {
        Optional<Libro> libroBuscado = buscarPorId(nuevoLibro.getId());

        if(libroBuscado.isPresent()) {

        libroBuscado.get().setIsbn(nuevoLibro.getIsbn());
        libroBuscado.get().setAutor(nuevoLibro.getAutor());
        libroBuscado.get().setEditorial(nuevoLibro.getEditorial());
        libroBuscado.get().setTitulo(nuevoLibro.getTitulo());
        libroBuscado.get().setFechaPublicacion(nuevoLibro.getFechaPublicacion());
        return libroBuscado.get();
    }

        return null;
    }    
    

    public void eliminar(int id) {
        listaLibros.removeIf(libro -> libro.getId() == id);
    }
}

