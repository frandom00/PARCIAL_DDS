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

    public void agregarAlgo() {
        Scanner can = new Scanner(System.in);
        boolean noTermine = true;
        System.out.println("1. Agregar pelicula a paquete");
        System.out.println("2. Agregar paquete a paquete");

        int cant = can.nextInt();
        while(noTermine) {
            if (cant == 1) {
                paquete.add(TopRated.obtenerPelicula());
                noTermine = false;
            } else if (cant == 2) {
                Paquete unPaquete = new Paquete();
                unPaquete.crearNuevo();
                noTermine = false;
            } else {
                System.out.println("Te equivocaste, solo podes poner 1 o 2!");
                System.out.println("1. Agregar pelicula a paquete");
                System.out.println("2. Agregar paquete a paquete");
            }
        }
    }



    public void crearNuevo() {
        Scanner can = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos que desea en el paquete");
        int cant = can.nextInt();
        for(int i = 0; i < cant; i ++) {
            this.agregarAlgo();
        }
    }
}
