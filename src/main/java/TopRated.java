import java.io.IOException;

public class TopRated extends Busqueda{

    public static void realizarBusqueda() throws IOException {
        Ruleta miRuleta = Ruleta.getInstancia();
        (miRuleta.obtenerPelicula()).mostrarPeli();
        return;
    }
}
