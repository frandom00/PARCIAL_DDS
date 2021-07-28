import java.time.LocalDate;
import java.util.*;

public class Pelicula {
    public boolean adult;
    public String backdrop_path;
    public List<Integer> genre_ids;
    public int id;
    public String original_language;
    public String original_title;
    public String overview;
    public Double popularity;
    public String poster_path;
    public String release_date;
    public String title;
    public boolean video;
    public Double vote_average;
    public int vote_count;
    public int nota;

    public Pelicula pelicula(){
        return new Pelicula();
    }

    public void mostrarPeli() {
        System.out.printf("Titulo %s %n y el titulo en el idioma original es %s %n", title, original_title);
    }

    public void darNombreYnota(String nombrePeli,int nota1) {
        original_title = nombrePeli;
        nota = nota1;
    }

    public void mostrarPelicula() {
        System.out.println("El nombre de la pelicula es: " + title);
        System.out.println("La puntuacion que le pusiste es: " + nota);
        System.out.println("------------------------------------------------------");
    }

    public String getNombre() {
        return original_title;
    }

    public void mostrarPeliVista() {
        System.out.println("El nombre de la pelicula es: " + title);
        System.out.println("------------------------------------------------------");
    }

    public void darNombre(String nombrePeli) {
        original_title = nombrePeli;
    }
}
