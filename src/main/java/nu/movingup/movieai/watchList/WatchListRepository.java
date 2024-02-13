package nu.movingup.movieai.watchList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList, UUID> {
    @Query("SELECT w FROM WatchList w WHERE w.id = :watchListId")
    List<WatchList> findByWatchListId(@Param("watchListId") UUID watchListId);
}
