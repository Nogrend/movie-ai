package nu.movingup.movieai.movies.omdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record OmdbSearchResponse(@JsonProperty("Search") List<OmdbSimpleMovie> movies) { }


