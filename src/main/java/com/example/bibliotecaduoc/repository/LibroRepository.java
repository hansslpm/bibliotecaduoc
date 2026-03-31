package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {
    
    private List<Libro> listaLibros;

    // DATOS FAKE
    public void fakeData() {
        listaLibros = new ArrayList<>(Arrays.asList(
        new Libro(1, "978-8437604947", "Pedro Páramo", "Editorial RM", 1955, "Juan Rulfo"),
        new Libro(2, "978-0141187761", "1984", "Secker & Warburg", 1949, "George Orwell"),
        new Libro(3, "978-8420471839", "Rayuela", "Sudamericana", 1963, "Julio Cortázar"),
        new Libro(4, "978-0618260300", "El Hobbit", "George Allen & Unwin", 1937, "J.R.R. Tolkien"),
        new Libro(5, "978-0140449136", "Crimen y Castigo", "The Russian Messenger", 1866, "Fiódor Dostoyevski"),
        new Libro(6, "978-8420651323", "El Aleph", "Editorial Losada", 1949, "Jorge Luis Borges"),
        new Libro(7, "978-0307474728", "La Casa de los Espíritus", "Plaza & Janés", 1982, "Isabel Allende"),
        new Libro(8, "978-0451524935", "Rebelión en la Granja", "Secker & Warburg", 1945, "George Orwell"),
        new Libro(9, "978-0060850524", "Un Mundo Feliz", "Chatto & Windus", 1932, "Aldous Huxley"),
        new Libro(10, "978-0307350435", "Crónica de una Muerte Anunciada", "Oveja Negra", 1981, "Gabriel García Márquez")
));
    }


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


    public Optional<Libro> readById(int id) {
        return listaLibros.stream().filter(x -> x.getId() == id).findFirst();
    }


    public Optional<Libro> readByIsbn(String isbn) {
        return listaLibros.stream().filter(x -> x.getIsbn().equalsIgnoreCase(isbn)).findFirst();
    }


    public Libro updateLibro(int id, Libro nuevoLibro) {
        Optional<Libro> oldLibro = readById(id);

        if(oldLibro != null) {
            oldLibro.get().setAutor(nuevoLibro.getAutor());
            oldLibro.get().setEditorial(nuevoLibro.getEditorial());
            oldLibro.get().setFechaPublicacion(nuevoLibro.getFechaPublicacion());
            oldLibro.get().setIsbn(nuevoLibro.getIsbn());
            oldLibro.get().setTitulo(nuevoLibro.getTitulo());
            return oldLibro.get();
        }
        return null;
    }


    public boolean deleteLibro(int id) {
        return listaLibros.removeIf(x -> x.getId() == id);
        }
}

