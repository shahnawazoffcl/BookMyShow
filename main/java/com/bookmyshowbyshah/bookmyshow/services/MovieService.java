package com.bookmyshowbyshah.bookmyshow.services;

import com.bookmyshowbyshah.bookmyshow.models.Movie;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface MovieService {

    public Movie addMovie(Movie movie);
    public Movie updateMovie(Movie movie);
    public Movie getMovie(UUID movieId);
    public List<Movie> getAllMovies();
    public void deleteMovie(UUID movieId);

    Movie getMovieByTitle(String movieTitle);

    List<Date> getShowDatesByMovieTitle(String movieTitle);
}
