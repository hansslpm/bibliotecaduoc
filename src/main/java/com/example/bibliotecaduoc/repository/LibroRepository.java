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


    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    public Libro agregarLibro(Libro libro) {
        listaLibros.add(libro);
        return libro;
    }


    // VERIFICAR EN CASA CUANDO EL LIBRO NO SE ENCUENTRA, DEVOLVER NULO EN VEZ DE Opcional.isEmpty()
    public Libro buscarPorId(int id) {
            return listaLibros.stream().filter(libro -> libro.getId() == id).findFirst().orElse(null);
        }

    public Libro buscarPorIsbn(String isbn) {
            return listaLibros.stream().filter(libro -> libro.getIsbn().equalsIgnoreCase(isbn)).findFirst().orElse(null);
        }

    public Libro actualizar(Libro nuevoLibro) {
        Libro libroBuscado = buscarPorId(nuevoLibro.getId());

        if(libroBuscado != null) {

        libroBuscado.setIsbn(nuevoLibro.getIsbn());
        libroBuscado.setAutor(nuevoLibro.getAutor());
        libroBuscado.setEditorial(nuevoLibro.getEditorial());
        libroBuscado.setTitulo(nuevoLibro.getTitulo());
        libroBuscado.setFechaPublicacion(nuevoLibro.getFechaPublicacion());
        return libroBuscado;
    }

        return null;
    }    
    

    public void eliminar(int id) {
        listaLibros.removeIf(libro -> libro.getId() == id);
    }
}

