package nu.movingup.movieai.watchList.events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public record MovieAddedToWatchListEvent(
        @TargetAggregateIdentifier
        UUID watchListId,
        String movieId
) {
}