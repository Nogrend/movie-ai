package nu.movingup.movieai.watchList;

import nu.movingup.movieai.watchList.commands.AddMovieToWatchListCommand;
import nu.movingup.movieai.watchList.commands.CreateWatchListCommand;
import nu.movingup.movieai.watchList.commands.DeleteMovieFromWatchListCommand;
import nu.movingup.movieai.watchList.events.MovieAddedToWatchListEvent;
import nu.movingup.movieai.watchList.events.MovieDeletedFromWatchListEvent;
import nu.movingup.movieai.watchList.events.WatchListCreatedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class WatchListAggregateTest {
    private FixtureConfiguration<WatchListAggregate> fixture;

    @BeforeEach
    void setUp() {
        fixture = new AggregateTestFixture<>(WatchListAggregate.class);
    }

    @Test
    public void testWatchListCreatedEvent() {
        var watchListId = UUID.randomUUID();
        fixture.givenNoPriorActivity()
                .when(new CreateWatchListCommand(watchListId))
                .expectEvents(new WatchListCreatedEvent(watchListId));
    }

    @Test
    public void testMovieAddedToWatchListEvent() {
        var watchListId = UUID.randomUUID();
        var movieId = "tt1234567";
        fixture.given(new WatchListCreatedEvent(watchListId))
                .when(new AddMovieToWatchListCommand(watchListId, movieId))
                .expectEvents(new MovieAddedToWatchListEvent(watchListId, movieId))
                .expectState(state -> {
                    assertThat(state.getMovieIds()).isEqualTo(List.of(movieId));
                });
    }

    @Test
    public void testMovieDeletedFromWatchListEvent() {
        var watchListId = UUID.randomUUID();
        var movieId = "tt1234567";
        fixture.given(new WatchListCreatedEvent(watchListId),
                        new MovieAddedToWatchListEvent(watchListId, movieId))
                .when(new DeleteMovieFromWatchListCommand(watchListId, movieId))
                .expectEvents(new MovieDeletedFromWatchListEvent(watchListId, movieId))
                .expectState(state -> {
                    assertThat(state.getMovieIds()).isEmpty();
                });
    }
}
