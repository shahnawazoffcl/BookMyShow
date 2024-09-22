package com.bookmyshowbyshah.bookmyshow.Controllers.utils;

import com.bookmyshowbyshah.bookmyshow.dto.ShowResponseDTO;
import com.bookmyshowbyshah.bookmyshow.exceptions.ShowNotFoundException;
import com.bookmyshowbyshah.bookmyshow.models.Show;

public class ShowControllerUtils {

    public static ShowResponseDTO convertShowToShowResponseDTO(Show show){
        ShowResponseDTO showResponseDTO = new ShowResponseDTO();
        showResponseDTO.setId(show.getId());
        showResponseDTO.setMovieName(show.getMovie().getName());
        showResponseDTO.setTheatreName(show.getScreen().getTheatre().getName());
        showResponseDTO.setStartTime((show.getStartTime()));
        showResponseDTO.setEndTime(show.getEndTime());
        showResponseDTO.setShowDate(show.getShowDate());
        return showResponseDTO;
    }

    public static boolean validateShow(Show show) {
        return show != null;
    }
}
