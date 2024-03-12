package nu.movingup.movieai.movies;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExtendedMovie(
        String title,
        String year,
        String rated,
        String released,
        String runtime,
        String genre,
        String director,
        String writer,
        String actors,
        String plot,
        String language,
        String country,
        String awards,
        String poster,
        String imdbRating,
        String imdbVotes,
        String imdbID,
        String type,
        String boxOffice,
        String response
) {
}
