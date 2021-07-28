import java.util.ArrayList;
import java.util.List;

public class Paquete extends AlgoPaVer {
    List<AlgoPaVer> paquete = new ArrayList<>();

    public void agregarPelicula(Pelicula unaPeli) {
        paquete.add(unaPeli);
    }

    @Override
    public void mostrarAlgoPaVer() {
        for (AlgoPaVer p : paquete) {
            p.mostrarAlgoPaVer();
        }
    }

    @Override
    public boolean tieneElNombre(String unNombre) {
        return paquete.stream().anyMatch(algoPaVer -> algoPaVer.tieneElNombre(unNombre));
    }
}
