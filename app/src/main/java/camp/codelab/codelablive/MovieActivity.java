package camp.codelab.codelablive;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import camp.codelab.codelablive.databinding.ActivityMovieBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieActivity extends AppCompatActivity {

    ActivityMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie);

        loadMovie();
    }

    private void loadMovie() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OMDBInterface omdbInterface = retrofit.create(OMDBInterface.class);

        Call<MovieModel> call = omdbInterface.getMovie("tt1431045");

        Toast.makeText(this, "REQUEST STARTED", Toast.LENGTH_SHORT).show();

        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                binding.setMovie(response.body());
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Toast.makeText(MovieActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
