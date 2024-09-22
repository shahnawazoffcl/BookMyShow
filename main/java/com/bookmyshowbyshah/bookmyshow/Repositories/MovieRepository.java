package com.bookmyshowbyshah.bookmyshow.Repositories;

import com.bookmyshowbyshah.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

    Movie findByTitle(String movieTitle);

    List<Date> getShowDatesByTitle(String movieTitle);
}
