package com.bookmyshowbyshah.bookmyshow.Controllers;

import com.bookmyshowbyshah.bookmyshow.Controllers.utils.MovieControllerUtils;
import com.bookmyshowbyshah.bookmyshow.client.UserServiceClient;
import com.bookmyshowbyshah.bookmyshow.dto.*;
import com.bookmyshowbyshah.bookmyshow.exceptions.InvalidTokenException;
import com.bookmyshowbyshah.bookmyshow.models.*;
import com.bookmyshowbyshah.bookmyshow.services.MovieService;
import com.bookmyshowbyshah.bookmyshow.services.SeatService;
import com.bookmyshowbyshah.bookmyshow.services.ShowService;
import com.bookmyshowbyshah.bookmyshow.services.TheatreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {

    private final MovieService movieService;
    private final UserServiceClient userServiceClient;
    private final TheatreService theatreService;
    private final ShowService showService;
    private final SeatService seatService;


    @Autowired
    public MovieController(MovieService movieService, UserServiceClient userServiceClient, TheatreService theatreService, ShowService showService, SeatService seatService) {
        this.movieService = movieService;
        this.userServiceClient = userServiceClient;
        this.theatreService = theatreService;
        this.showService = showService;
        this.seatService = seatService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<ResponseDTO> getAllMovies(@RequestHeader("token") String token) throws RuntimeException{
        validateUSer(token);
//        throw new InvalidTokenException("Not Implemented");
        List<MovieResponseDTO> moviesDTO = new ArrayList<>();
        for (Movie movie : this.movieService.getAllMovies()) {
            moviesDTO.add(MovieControllerUtils.convertMovieToMovieResponseDTO(movie));
        }
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Movies Fetched Successfully");
        responseDTO.setMessageCode("200");
        responseDTO.setMovies(moviesDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(path = "/id/{movieId}")
    public ResponseEntity<MovieResponseDTO> getMovie(@PathVariable UUID movieId, @RequestHeader("token") String token) {
        return ResponseEntity.ok(MovieControllerUtils.convertMovieToMovieResponseDTO(this.movieService.getMovie(movieId)));
    }


    @GetMapping(path = "/theatre/{movieTitle}")
    public ResponseEntity<List<Theatre>> getTheatresForMovie(@PathVariable String movieTitle, Date showDate){
        return ResponseEntity.ok(this.theatreService.getTheatresbyMovieTitleAndShowDate(movieTitle, showDate));
    }

    @GetMapping(path = "{movieTitle}")
    public ResponseEntity<MovieResponseDTO> getMovie(@PathVariable String movieTitle, @RequestHeader("token") String token){
        validateUSer(token);
        MovieResponseDTO movieResponseDTO = MovieControllerUtils.convertMovieToMovieResponseDTO(this.movieService.getMovieByTitle(movieTitle));
        return ResponseEntity.ok(movieResponseDTO);
    }

    @GetMapping(path = "/shows/{movieTitle}")
    public ResponseEntity<List<ShowResponseDTO>> getShows(@PathVariable String movieTitle, @RequestHeader("token") String token){
        validateUSer(token);
        List<Show> shows = this.showService.getShowsByMovie(movieTitle);
        List<ShowResponseDTO> showResponseDTOList = new ArrayList<>();
        for (Show show : shows) {
            ShowResponseDTO showResponseDTO = MovieControllerUtils.convertShowToShowResponseDTO(show);
            showResponseDTOList.add(showResponseDTO);
        }
        return ResponseEntity.ok(showResponseDTOList);
    }

    @GetMapping(path = "select-seats/{showId}")
    public ResponseEntity<List<ShowSeat>> getSeatsForShow(@PathVariable String showId){
        Show show = showService.getShowByShowId(showId);
        List<ShowSeat> showSeats = seatService.getSeatsForShow(show);
         return ResponseEntity.ok(showSeats);
    }



    private void validateUSer(String token){
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));
        ObjectMapper objectMapper = new ObjectMapper();
        SessionStatus response ;
        JwtPayloadDTO jwtPayload = null;
        try {
            jwtPayload = objectMapper.readValue(payload, JwtPayloadDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        ValidateTokenDTO validateTokenDTO = new ValidateTokenDTO(jwtPayload.getUserId(), token);
        response = userServiceClient.validateToken(validateTokenDTO);
        if(response.equals(SessionStatus.ENDED)){
            throw new InvalidTokenException("Invalid Token");
        }

    }


}
