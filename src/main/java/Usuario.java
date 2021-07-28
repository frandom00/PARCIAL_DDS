import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String nombre;
    String contra;
    public Suscripcion miSuscripcion;
    List<Pelicula> listaPuntuadas = new ArrayList<>();
    List<AlgoPaVer> todoLoVisto = new ArrayList<>();
    int money=20;

    public Usuario(String usuario, String contras, Suscripcion modo) {
        nombre = usuario;
        contra = contras;
        miSuscripcion = modo;
    }


    public String getNombre() {
        return nombre;
    }
    public String getContra() {
        return contra;
    }

    public void decimeQuienSoy() {
        System.out.println(nombre);
        System.out.println(contra);
        return;
    }

    public void cambiarEstado(Suscripcion unModo) {
        miSuscripcion = miSuscripcion.cambiarModo(unModo, this);
    }

    public boolean restarCredito(int i) {
        if( money >=i ){
            this.money =money-1;
            return true;
        }else{
            return false;
        }
    }

    public Suscripcion miSuscripcion() {
        return miSuscripcion;
    }

    public void agregarVotadas(Pelicula peli) {
        listaPuntuadas.add(peli);
    }

    public void agregarVistas(Pelicula peli) {
        todoLoVisto.add(peli);
    }

    public boolean laVio(String nombrePeli) {

        return todoLoVisto.stream().anyMatch(algoPaVer -> algoPaVer.tieneElNombre(nombrePeli));
    }



    public void mostrarPeliculasPuntuadas() {
        for(Pelicula p : listaPuntuadas) {
            p.mostrarPeli();
        }
    }

    public void mostrarPeliculasVistas() {
        for(AlgoPaVer p : todoLoVisto) {
            p.mostrarAlgoPaVer();
        }
    }
}
