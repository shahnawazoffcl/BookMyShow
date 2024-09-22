package com.bookmyshowbyshah.bookmyshow.services.impl;

import com.bookmyshowbyshah.bookmyshow.Repositories.ShowSeatRepository;
import com.bookmyshowbyshah.bookmyshow.models.Show;
import com.bookmyshowbyshah.bookmyshow.models.ShowSeat;
import com.bookmyshowbyshah.bookmyshow.services.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final ShowSeatRepository showSeatRepository;

    public SeatServiceImpl(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    @Override
    public List<ShowSeat> getSeatsForShow(Show show) {
        List<ShowSeat> showSeats;
        try{
        showSeats = showSeatRepository.getSeatsByShowId(show.getId());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

        return showSeats;
    }
}
