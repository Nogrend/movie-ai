package nu.movingup.movieai.watchList.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public record DeleteMovieFromWatchListCommand(
        @TargetAggregateIdentifier
        UUID watchListId,
        String movieId
) {
}
