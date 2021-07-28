import java.util.ArrayList;
import java.util.List;

public class Paquete {
    List<Pelicula> paquete = new ArrayList<>();

    public void agregarPelicula(Pelicula unaPeli) {
        paquete.add(unaPeli);
    }

    public void mostrarPaquete() {
        for (Pelicula p : paquete) {
            p.mostrarPeli();
        }
    }
}
