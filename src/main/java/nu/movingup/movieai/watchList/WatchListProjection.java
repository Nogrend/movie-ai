package nu.movingup.movieai.watchList;

import nu.movingup.movieai.watchList.events.MovieAddedToWatchListEvent;
import nu.movingup.movieai.watchList.events.WatchListCreatedEvent;
import nu.movingup.movieai.watchList.queries.GetWatchListById;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Collections.*;

@Service
public class WatchListProjection {

    private final WatchListRepository watchListRepository;

    public WatchListProjection(WatchListRepository watchListRepository) {
        this.watchListRepository = watchListRepository;
    }

    @EventHandler
    public void on(WatchListCreatedEvent event) {
        var watchList = new WatchList(event.watchListId(), emptyList());
        watchListRepository.save(watchList);
    }

    @EventHandler
    public void on(MovieAddedToWatchListEvent event) {
        var watchList = watchListRepository.findById(event.watchListId()).orElseThrow();
        watchList.addMovieToWatchList(event.movieId());
        watchListRepository.save(watchList);
    }

    @QueryHandler
    public Optional<WatchList> on(GetWatchListById query) {
        return watchListRepository.findById(query.id());
    }
}
