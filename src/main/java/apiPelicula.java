
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

interface ApiPelicula {

    @GET("movie/top_rated")
    Call<ListaPeliculas> listaPeliculas(@Query("language") String idiomaRespuesta, @Query("page") Integer pagina, @Query("include_adult") boolean paraAdultos, @Query("region") String region, @Query("api_key") String apiKey);

    @GET("genre/movie/list")
    Call<Generos> listGeneros(@Query("language") String idiomaRespuesta, @Query("api_key") String apiKey);


    @GET("discover/movie")
    Call<ListaPeliculas> peliculasConGenero(@Query("language") String idiomaRespuesta, @Query("api_key") String apiKey, @Query("with_genres") Integer generos);


}
