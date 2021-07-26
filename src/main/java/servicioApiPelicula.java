
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

import java.io.IOException;
import java.util.*;

public class servicioApiPelicula {
    private static String apiKey = "2a28ead8355bebf7699f1a5084b2208a";
    private static servicioApiPelicula instancia = null;
    private Retrofit retrofit;
    private static final String urlApi = "https://api.themoviedb.org/3/";
    private servicioApiPelicula() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static servicioApiPelicula getInstancia() {
        if (instancia == null) {
            instancia = new servicioApiPelicula();
        }
        return instancia;
    }

    public ListaPeliculas obtenerPaginaDePeliculas(int paginaPedida) throws IOException{
        ApiPelicula apiPelicula = this.retrofit.create(ApiPelicula.class);
        Call<ListaPeliculas> solicitarListaPeliculas = apiPelicula.listaPeliculas("es", paginaPedida, true, "AR", apiKey);
        Response<ListaPeliculas> respuestaPeliculas = solicitarListaPeliculas.execute();
        return respuestaPeliculas.body();
    }

    public int cuantasPaginasHay() throws IOException{
        ListaPeliculas listaParaObtenercantPaginas = this.obtenerPaginaDePeliculas(1);
        return listaParaObtenercantPaginas.ultimaPagina();
    }

    public void mostrarGeneros()  throws IOException{
        ApiPelicula apiPelicula = this.retrofit.create(ApiPelicula.class);
        Call<Generos> listGeneros = apiPelicula.listGeneros("es", apiKey);
        Response<Generos> respuestaGeneros = listGeneros.execute();
        Generos generosObj = respuestaGeneros.body();
            for(int i=0; i<19;i++){
                (generosObj.genres[i]).mostrarGenero();
            }
    }

    public ListaPeliculas obtenerPeliculasPorGenero(Integer miGenero) throws IOException{
        ApiPelicula apiPelicula = this.retrofit.create(ApiPelicula.class);
        Call<ListaPeliculas> listaPeliculas = apiPelicula.peliculasConGenero("es", apiKey, miGenero);
        Response<ListaPeliculas> respuestaPeliculas = listaPeliculas.execute();
        ListaPeliculas peliculas = respuestaPeliculas.body();
        return peliculas;
    }


}
