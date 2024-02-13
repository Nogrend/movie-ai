package nu.movingup.movieai.watchList;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WatchListRepository extends JpaRepository<WatchList, UUID> {
}
