package com.bookmyshowbyshah.bookmyshow.Controllers.utils;

import com.bookmyshowbyshah.bookmyshow.dto.MovieResponseDTO;
import com.bookmyshowbyshah.bookmyshow.dto.ShowResponseDTO;
import com.bookmyshowbyshah.bookmyshow.models.Movie;
import com.bookmyshowbyshah.bookmyshow.models.Show;
import com.bookmyshowbyshah.bookmyshow.models.ShowSeat;

import java.util.ArrayList;
import java.util.List;

public class MovieControllerUtils {
    public static MovieResponseDTO convertMovieToMovieResponseDTO(Movie movie){
        MovieResponseDTO movieResponseDTO = new MovieResponseDTO();
        movieResponseDTO.setId(movie.getId());
        movieResponseDTO.setName(movie.getName());
        movieResponseDTO.setDescription(movie.getDescription());
        movieResponseDTO.setLanguage(movie.getLanguage());
        movieResponseDTO.setReleaseDate(movie.getReleaseDate());
        movieResponseDTO.setDurationInMinutes(movie.getDurationInMinutes());
        movieResponseDTO.setPosterUrl(movie.getPosterUrl());
        movieResponseDTO.setTitle(movie.getTitle());
        return movieResponseDTO;
    }

    public static ShowResponseDTO convertShowToShowResponseDTO(Show show) {
        ShowResponseDTO showResponseDTO = new ShowResponseDTO();
        showResponseDTO.setId(show.getId());
        showResponseDTO.setShowDate(show.getShowDate());
        showResponseDTO.setStartTime(show.getStartTime());
        showResponseDTO.setEndTime(show.getEndTime());
        showResponseDTO.setTheatreName(show.getTheatre().getName());
        showResponseDTO.setTheatreId(show.getTheatre().getId());
        showResponseDTO.setMovieName(show.getMovie().getName());
        return showResponseDTO;
    }


}
