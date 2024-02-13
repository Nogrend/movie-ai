package nu.movingup.movieai.watchList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ElementCollection;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;

@Entity
public class WatchList {
    @Id
    private final UUID id;

    @ElementCollection
    private final List<String> movieIds;

    // todo it want no-argument constructor, is below a good solution?
    public WatchList() {
        this.movieIds = emptyList();
        this.id = null;
    }

    public WatchList(UUID id, List<String> movieIds) {
        this.id = id;
        this.movieIds = movieIds;
    }
}
