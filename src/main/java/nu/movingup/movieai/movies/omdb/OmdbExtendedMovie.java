package nu.movingup.movieai.movies.omdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OmdbExtendedMovie(
        @JsonProperty("Title") String title,
        @JsonProperty("Year") String year,
        @JsonProperty("Rated") String rated,
        @JsonProperty("Released") String released,
        @JsonProperty("Runtime") String runtime,
        @JsonProperty("Genre") String genre,
        @JsonProperty("Director") String director,
        @JsonProperty("Writer") String writer,
        @JsonProperty("Actors") String actors,
        @JsonProperty("Plot") String plot,
        @JsonProperty("Language") String language,
        @JsonProperty("Country") String country,
        @JsonProperty("Awards") String awards,
        @JsonProperty("Poster") String poster,
        @JsonProperty("imdbRating") String imdbRating,
        @JsonProperty("imdbVotes") String imdbVotes,
        @JsonProperty("imdbID") String imdbID,
        @JsonProperty("Type") String type,
        @JsonProperty("BoxOffice") String boxOffice,
        @JsonProperty("Response") String response
) {
}
