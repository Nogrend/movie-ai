package nu.movingup.movieai.watchList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList, UUID> {
}
