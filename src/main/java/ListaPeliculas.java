import java.util.*;
public class ListaPeliculas {
    int page;
    public Pelicula[] results;
    int total_pages;


    public void mostrarPeliculas() {
        for (Pelicula p:results) {
            p.mostrarPeli();
        }
    }
    public int ultimaPagina() {
        return total_pages;
    }
}
