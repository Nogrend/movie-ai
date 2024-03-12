package nu.movingup.movieai.movies.omdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OmdbSimpleMovie(
        @JsonProperty("Title") String title,
        @JsonProperty("Year") String year,
        @JsonProperty("imdbID") String imdbID,
        @JsonProperty("Type") String type,
        @JsonProperty("Poster") String poster
) {
}