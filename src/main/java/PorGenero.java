import java.io.IOException;
import java.util.Scanner;

public class PorGenero extends Busqueda{

    public static void realizarBusqueda() throws IOException {
        Scanner scn = new Scanner(System.in);
        servicioApiPelicula miApi = servicioApiPelicula.getInstancia();
        miApi.mostrarGeneros();
        System.out.println("Ingrese Un Genero segun ID");
        Integer miGenero = scn.nextInt();
        ListaPeliculas miLista = miApi.obtenerPeliculasPorGenero(miGenero);
        Ruleta miRuleta = Ruleta.getInstancia();
        (miRuleta.darRandom(miLista)).mostrarPeli();
    }
}
