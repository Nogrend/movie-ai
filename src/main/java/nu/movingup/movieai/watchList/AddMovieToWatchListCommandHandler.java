package nu.movingup.movieai.watchList;

import nu.movingup.movieai.watchList.commands.AddMovieToWatchListCommand;
import nu.movingup.movieai.watchList.commands.CreateWatchListCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

// todo is this a Aggregate and so wrong naming?
@Component
public class AddMovieToWatchListCommandHandler {

    private final CommandGateway commandGateway;

    public AddMovieToWatchListCommandHandler(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @CommandHandler
    public void on(AddMovieToWatchListCommand command){
        commandGateway.send(new CreateWatchListCommand());
    }
}
