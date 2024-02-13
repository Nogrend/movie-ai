package nu.movingup.movieai.watchList.commands;

import java.util.UUID;

public record AddMovieToWatchListCommand(
        UUID watchListId,
        String movieId
) {
}
