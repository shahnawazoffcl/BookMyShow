package com.bookmyshowbyshah.bookmyshow.services.impl;

import com.bookmyshowbyshah.bookmyshow.Repositories.ShowRepository;
import com.bookmyshowbyshah.bookmyshow.Repositories.TheatreRepository;
import com.bookmyshowbyshah.bookmyshow.exceptions.ShowNotFoundException;
import com.bookmyshowbyshah.bookmyshow.models.Show;
import com.bookmyshowbyshah.bookmyshow.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final TheatreRepository theatreRepository;

    @Autowired
    public ShowServiceImpl(ShowRepository showRepository,
                           TheatreRepository theatreRepository) {
        this.showRepository = showRepository;
        this.theatreRepository = theatreRepository;
    }

    @Override
    public Show getShow(UUID showId) {

        return this.showRepository.findById(showId).orElseThrow(() -> new ShowNotFoundException("Show not found"));
    }

    @Override
    public List<Show> getAllShows() {
        return this.showRepository.findAll();
    }

    @Override
    public List<Date> getShowDatesByMovieTitle(String movieTitle) {
        List<Object> datesObj =  this.showRepository.getShowDatesByMovieTitle(movieTitle);
        List<Date> dates = (List<Date>) (List<?>) datesObj;
        return dates;
    }

    @Override
    public List<Show> getShowsByMovie(String movieTitle) {
        return this.showRepository.getShowsByMovieTitle(movieTitle);
    }

    @Override
    public Show getShowByShowId(String showId) {
        return showRepository.getShowById(UUID.fromString(showId));
    }
}
