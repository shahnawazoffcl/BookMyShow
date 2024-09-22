package com.bookmyshowbyshah.bookmyshow.Repositories;

import com.bookmyshowbyshah.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShowRepository extends JpaRepository<Show, UUID> {
    @Query("SELECT s.showDate FROM Show s WHERE s.movie.title = :movieTitle")
    List<Object> getShowDatesByMovieTitle(String movieTitle);

    List<Show> getShowsByMovieTitle(String movieTitle);

    Show getShowById(UUID id);
}
