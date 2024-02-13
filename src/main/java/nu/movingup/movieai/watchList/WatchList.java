package nu.movingup.movieai.watchList;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ElementCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;

@Entity
public class WatchList {
    @Id
    private UUID id;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> movieIds;

    // todo it want a no-argument constructor, is below a good solution?
    public WatchList() {
        this.id = null;
        this.movieIds = new ArrayList<>();
    }

    public WatchList(UUID id, List<String> movieIds) {
        this.id = id;
        this.movieIds = movieIds;
    }

    public UUID getId() {
        return id;
    }

    public List<String> getMovieIds() {
        return movieIds;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setMovieIds(List<String> movieIds) {
        this.movieIds = movieIds;
    }
}
