package nu.movingup.movieai.movies.omdb;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class OmdbHttpClient {
    private static final String OMDB_API_URL = "http://www.omdbapi.com/?apiKey=128a8b1c&s={jo}";

    public OmdbSearchResponse searchMovie(String query) {

        RestClient restClient = RestClient.create();

        var result = restClient.get()
                .uri("http://www.omdbapi.com/?apiKey=128a8b1c&s={query}", query)
                .retrieve()
                .body(OmdbSearchResponse.class);
        return result;
    }

    public OmdbExtendedMovie getMovieById(String id) {
        RestClient restClient = RestClient.create();

        return restClient.get()
                .uri("http://www.omdbapi.com/?apiKey=128a8b1c&i={id}", id)
                .retrieve()
                .body(OmdbExtendedMovie.class);
    }
}
