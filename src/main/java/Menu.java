import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Usuario yo;
    boolean sesionIniciada = false;
    public void iniciarMenu() throws IOException{

        Scanner sn = new Scanner(System.in);
        Scanner str = new Scanner(System.in);

        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Suscripcion modoSuscripcion;
        Sistema miSistema= Sistema.getInstancia();
        miSistema.cargarUsuarios();
        while (!salir) {

            System.out.println("1. Buscar");
            System.out.println("2. Crear Usuario");
            System.out.println("3. Iniciar Sesion");
            System.out.println("4. Puntuar Pelicula");
            System.out.println("5. Obtener Peliculas puntuadas");
            System.out.println("6. Agregar Pelicula Vista");
            System.out.println("7. Obtener Peliculas Vistas");
            System.out.println("8. Obtener Paquete de Peliculas Random");
            System.out.println("9. Cambiar Suscripcion");
            System.out.println("0. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        if (sesionIniciada) {
                            System.out.println("Has seleccionado Buscar");
                            System.out.println("Seleccione el metodo de busqueda");
                            System.out.println("1. Top rated");
                            System.out.println("2. Por genero");
                            opcion = sn.nextInt();
                            this.busquedaPor(opcion);

                        }else{
                            System.out.println("Seleccione la opcion 3 para iniciar sesion y vuelva a intentarlo");
                        }
                        break;
                    case 2:
                        System.out.println("Has seleccionado Crear Usuario");
                        System.out.println("Ingrese Usuario");
                        String usuarioProvisorio = str.nextLine();
                        while (miSistema.usuarioNoValido(usuarioProvisorio)) {
                            System.out.println("Nombre de usuario no valido, vuelva a intentarlo");
                            usuarioProvisorio = str.nextLine();
                        }
                        System.out.println("Ingrese Contrasena");
                        String contrasenaProvisoria = str.nextLine();
                        while (miSistema.contrasenaNoValida(contrasenaProvisoria)) {
                            System.out.println("Contrasena no valida, vuelva a intentarlo");
                            contrasenaProvisoria = str.nextLine();
                        }
                        modoSuscripcion = this.menuSuscripcion();
                        Usuario miUsuario = new Usuario(usuarioProvisorio, contrasenaProvisoria, modoSuscripcion);
                        miSistema.agregarUsuario(miUsuario);
                        yo=miUsuario;
                        sesionIniciada=true;

                        break;
                    case 3:
                        System.out.println("Has seleccionado Iniciar Sesion");
                        while (!sesionIniciada) {
                            System.out.println("Ingrese usuario");
                            usuarioProvisorio = str.nextLine();
                            System.out.println("Ingrese contrasena");
                            contrasenaProvisoria = str.nextLine();
                            if (miSistema.validarIngreso(usuarioProvisorio, contrasenaProvisoria)) {
                                yo = miSistema.dameUsuario(usuarioProvisorio);
                                sesionIniciada = true;
                            }
                        }

                        break;
                    case 4:
                        System.out.println("Ingrese el nombre de la pelicula que desea votar ");
                        String nombrePeli = str.nextLine();
                        int nota = sn.nextInt();
                        yo.miSuscripcion().votarPelicula(nombrePeli,nota,yo);
                        break;
                    case 5:
                        yo.mostrarPeliculasPuntuadas();
                        break;
                    case 6:
                        System.out.println("Ingrese el nombre de la pelicula que vio ");
                        String nombrePeliVista = str.nextLine();
                        yo.miSuscripcion().agregarVista(nombrePeliVista,yo);
                        break;
                    case 7:
                        yo.mostrarPeliculasVistas();
                        break;
                    case 8:
                        Paquete miPaquete = new Paquete();
                        miPaquete.crearNuevo();
                        yo.todoLoVisto.add(miPaquete);
                        break;
                    case 9:
                        Suscripcion unaSus = this.menuSuscripcion();
                        yo.cambiarEstado(unaSus);
                        break;
                    case 10:
                        List<Usuario> usuarios = null;
                        usuarios = UsuariosDAO.listaDeUsuarios();
                        for(Usuario u : usuarios) {
                            u.mostrarUsuario();
                        }
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 0 y 9");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    private void busquedaPor(int opcion) throws IOException{
        Scanner scn = new Scanner(System.in);
        if(opcion >=1 && opcion <=3) {
            try {
                switch (opcion) {
                    case 1:
                        TopRated.realizarBusqueda();
                        break;
                    case 2:
                        PorGenero.realizarBusqueda();
                        break;
                    case 3:

                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scn.next();
            }
        }
    }

    private Suscripcion menuSuscripcion() {
        Scanner scn = new Scanner(System.in);
        int elegido;
        boolean noTermine = true;
        Suscripcion devolver = new SinSuscrip();

        while(noTermine) {
            System.out.println("Ingrese tipo de suscripcion");
            System.out.println("1. No deseo tener suscripcion");
            System.out.println("2. Deseo suscripcion NORMAL");
            System.out.println("3. Deseo suscripcion PREMIUM");
            try {
                System.out.println("Escribe una de las opciones");
                elegido = scn.nextInt();
                switch (elegido) {
                    case 1:
                        devolver = new SinSuscrip();
                        noTermine = false;
                        break;
                    case 2:
                        devolver = new Normal();
                        noTermine = false;
                        break;
                    case 3:
                        devolver = new Premium();
                        noTermine = false;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scn.next();
            }
        }
        return devolver;
    }
}