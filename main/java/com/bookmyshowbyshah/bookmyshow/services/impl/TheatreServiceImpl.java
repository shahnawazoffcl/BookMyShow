package com.bookmyshowbyshah.bookmyshow.services.impl;

import com.bookmyshowbyshah.bookmyshow.Repositories.TheatreRepository;
import com.bookmyshowbyshah.bookmyshow.models.Theatre;
import com.bookmyshowbyshah.bookmyshow.services.TheatreService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;

    public TheatreServiceImpl(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @Override
    public List<Theatre> getTheatresbyMovieTitleAndShowDate(String movieTitle, Date showDate) {
        return null;
//        return this.theatreRepository.getTheatresByMovieTitleAndShowDate(movieTitle, showDate);
    }
}
