package com.bookmyshowbyshah.bookmyshow.services;

import com.bookmyshowbyshah.bookmyshow.models.Show;
import com.bookmyshowbyshah.bookmyshow.models.ShowSeat;

import java.util.List;

public interface SeatService {
    List<ShowSeat> getSeatsForShow(Show show);
}
