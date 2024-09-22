package com.bookmyshowbyshah.bookmyshow.services;

import com.bookmyshowbyshah.bookmyshow.models.Theatre;

import java.util.Date;
import java.util.List;

public interface TheatreService {

    List<Theatre> getTheatresbyMovieTitleAndShowDate(String movieTitle, Date showDate);
}
