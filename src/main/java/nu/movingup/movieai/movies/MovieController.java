package nu.movingup.movieai.movies;

import nu.movingup.movieai.movies.omdb.OmdbHttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@RestController
public class MovieController {

    private final OmdbHttpClient omdbHttpClient;

    public MovieController(OmdbHttpClient omdbHttpClient) {
        this.omdbHttpClient = omdbHttpClient;
    }

    @GetMapping("/movies/search")
    public SearchResponse searchMovies(@RequestParam String query) {
        var omdbSearchResult = omdbHttpClient.searchMovie(query);
        var movies = ofNullable(omdbSearchResult.movies()).orElseGet(Collections::emptyList);
        return movies.stream().map(omdbMovie -> new SimpleMovie(omdbMovie.title(), omdbMovie.year(), omdbMovie.imdbID(), omdbMovie.type(), omdbMovie.poster())).collect(collectingAndThen(toList(), SearchResponse::new));
    }

    @GetMapping("/movies")
    public List<ExtendedMovie> getMovieById(@RequestParam List<String> id) {
        return id.stream()
                .map(omdbHttpClient::getMovieById)
                .map(omdbMovie -> new ExtendedMovie(
                        omdbMovie.title(),
                        omdbMovie.year(),
                        omdbMovie.rated(),
                        omdbMovie.released(),
                        omdbMovie.runtime(),
                        omdbMovie.genre(),
                        omdbMovie.director(),
                        omdbMovie.writer(),
                        omdbMovie.actors(),
                        omdbMovie.plot(),
                        omdbMovie.language(),
                        omdbMovie.country(),
                        omdbMovie.awards(),
                        omdbMovie.poster(),
                        omdbMovie.imdbRating(),
                        omdbMovie.imdbVotes(),
                        omdbMovie.imdbID(),
                        omdbMovie.type(),
                        omdbMovie.boxOffice(),
                        omdbMovie.response()
                ))
                .toList();
    }
}
