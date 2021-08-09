import java.time.LocalDate;
import java.util.*;

public class Pelicula extends AlgoPaVer {
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
        this.original_title = nombrePeli;
        this.nota = nota1;
    }

    public void mostrarPelicula() {
        System.out.println("El nombre de la pelicula es: " + original_title);
        System.out.println("La puntuacion que le pusiste es: " + nota);
        System.out.println("------------------------------------------------------");
    }


    @Override
    public boolean tieneElNombre(String unNombre) {
        return original_title.equals(unNombre);
    }

    @Override
    public void mostrarAlgoPaVer() {
        System.out.println("El nombre de la pelicula es: " + original_title);
        System.out.println("------------------------------------------------------");
    }

    public void darNombre(String nombrePeli) {
        this.original_title = nombrePeli;
    }
}
