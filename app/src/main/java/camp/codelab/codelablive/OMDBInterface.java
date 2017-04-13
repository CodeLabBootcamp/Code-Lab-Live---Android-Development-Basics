package camp.codelab.codelablive;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sabri on 4/13/17.
 */

public interface OMDBInterface {

    @GET("/")
    Call<MovieModel> getMovie(@Query("i") String imdbId);

}
