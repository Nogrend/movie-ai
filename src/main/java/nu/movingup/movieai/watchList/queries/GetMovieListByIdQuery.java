package nu.movingup.movieai.watchList.queries;


import java.util.UUID;

// todo why do we call it "...MovieList..." instead of "...WatchList..."?

public record GetMovieListByIdQuery(UUID id) {
}
