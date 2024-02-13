package nu.movingup.movieai.watchList;

import nu.movingup.movieai.watchList.commands.CreateWatchListCommand;
import nu.movingup.movieai.watchList.events.WatchListCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class WatchListAggregate {
    @AggregateIdentifier
    private UUID id;

    @CommandHandler
    public WatchListAggregate(CreateWatchListCommand command) {
        apply(new WatchListCreatedEvent(command.watchListId()));
    }

    // @EventHandler // in documentation the say "@EventSourcingHandler
    @EventSourcingHandler
    public void on(WatchListCreatedEvent event){
        this.id = event.watchListId();
    }

    protected WatchListAggregate(){};
}
