import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Ruleta {
    public Integer paginaElegida;
    public Integer offset;
    private static Ruleta instancia = null;

    public static Ruleta getInstancia() {
        if (instancia == null) {
            instancia = new Ruleta();
        }
        return instancia;
    }

    private void elegirPeliculaRandom(Integer cantPaginas) {
        paginaElegida = ThreadLocalRandom.current().nextInt(1, cantPaginas);
        offset = ThreadLocalRandom.current().nextInt(1, 20);
    }

    public Pelicula obtenerPelicula() throws IOException {
        servicioApiPelicula unServ = servicioApiPelicula.getInstancia();
        int cantPags = unServ.cuantasPaginasHay();
        elegirPeliculaRandom(cantPags);
        ListaPeliculas listaPeliculas = unServ.obtenerPaginaDePeliculas(paginaElegida);
        return listaPeliculas.results[offset];
    }

    public Pelicula darRandom(ListaPeliculas peliculas){
        offset = ThreadLocalRandom.current().nextInt(1, 19);
        return peliculas.results[offset];
    }
}
