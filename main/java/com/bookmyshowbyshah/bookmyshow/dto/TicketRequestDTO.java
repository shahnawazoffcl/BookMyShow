package com.bookmyshowbyshah.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class TicketRequestDTO {

    private UUID userId;
    private UUID showId;
    private List<UUID> seatIds;
}
