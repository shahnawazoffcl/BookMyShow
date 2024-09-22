package com.bookmyshowbyshah.bookmyshow.services;

import com.bookmyshowbyshah.bookmyshow.models.Show;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ShowService {

    public Show getShow(UUID showId);
    public List<Show> getAllShows();

    List<Date> getShowDatesByMovieTitle(String movieTitle);


    List<Show> getShowsByMovie(String movieTitle);

    Show getShowByShowId(String showId);
}
