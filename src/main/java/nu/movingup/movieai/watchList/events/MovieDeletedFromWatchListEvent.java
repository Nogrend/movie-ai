package nu.movingup.movieai.watchList.events;

import java.util.UUID;

public record MovieDeletedFromWatchListEvent(
        UUID watchListId,
        String movieId
) {
}
