package nu.movingup.movieai.watchList;

import nu.movingup.movieai.watchList.commands.AddMovieToWatchListCommand;
import nu.movingup.movieai.watchList.commands.CreateWatchListCommand;
import nu.movingup.movieai.watchList.events.MovieAddedToWatchListEvent;
import nu.movingup.movieai.watchList.events.WatchListCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class WatchListAggregate {
    @AggregateIdentifier
    private UUID id;
    private List<String> movieIds;

    protected WatchListAggregate() {
    }

    @CommandHandler
    public WatchListAggregate(CreateWatchListCommand command) {
        apply(new WatchListCreatedEvent(command.watchListId()));
    }

    @EventSourcingHandler
    public void on(WatchListCreatedEvent event) {
        this.id = event.watchListId();
        this.movieIds = new ArrayList<>();
    }

    @CommandHandler
    public void on(AddMovieToWatchListCommand command) {
        if (movieIsNotInWatchList(command.movieId())) {
            apply(new MovieAddedToWatchListEvent(command.watchListId(), command.movieId()));
        }
    }

    @EventSourcingHandler
    public void on(MovieAddedToWatchListEvent event) {
        this.movieIds.add(event.movieId());
    }

    private boolean movieIsNotInWatchList(String movieId) {
        return !this.movieIds.contains(movieId);
    }
}
