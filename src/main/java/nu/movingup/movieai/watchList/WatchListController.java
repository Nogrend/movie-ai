package nu.movingup.movieai.watchList;

import nu.movingup.movieai.watchList.commands.CreateWatchListCommand;
import nu.movingup.movieai.watchList.queries.GetWatchListById;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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
    public void createWatchList(@RequestBody CreateWatchListCommand command) {
        commandGateway.send(command);
    }

    @GetMapping("/watchlist/{id}")
    public CompletableFuture<Optional<WatchList>> getWatchListById(@PathVariable UUID id) {
        return queryGateway.query(
                new GetWatchListById(id),
                ResponseTypes.optionalInstanceOf(WatchList.class)
        );
    }
}
