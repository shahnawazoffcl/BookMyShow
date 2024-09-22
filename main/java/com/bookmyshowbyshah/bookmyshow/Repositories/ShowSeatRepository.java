package com.bookmyshowbyshah.bookmyshow.Repositories;

import com.bookmyshowbyshah.bookmyshow.models.Screen;
import com.bookmyshowbyshah.bookmyshow.models.Seat;
import com.bookmyshowbyshah.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, UUID> {
    List<ShowSeat> getSeatsByShowId(UUID showId);
}
