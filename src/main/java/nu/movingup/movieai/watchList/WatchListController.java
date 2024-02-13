package nu.movingup.movieai.watchList;

import nu.movingup.movieai.watchList.commands.CreateWatchListCommand;
import nu.movingup.movieai.watchList.queries.GetMovieListByIdQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
public class WatchListController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public WatchListController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/watchlist")
    public CompletableFuture<Void> createWatchList(@RequestBody CreateWatchListCommand command) {
        return commandGateway.send(command);
    }

    @GetMapping("/watchlist/{id}")
    public CompletableFuture<WatchList> getMovieListById(@PathVariable UUID id) {
        return queryGateway.query(new GetMovieListByIdQuery(id), ResponseTypes.instanceOf(WatchList.class));
    }
}
