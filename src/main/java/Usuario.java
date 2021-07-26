public class Usuario {
    String nombre;
    String contra;
    Suscripcion miSuscripcion;

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
}
