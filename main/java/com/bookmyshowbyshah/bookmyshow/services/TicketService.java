package com.bookmyshowbyshah.bookmyshow.services;

import com.bookmyshowbyshah.bookmyshow.models.Ticket;
import com.bookmyshowbyshah.bookmyshow.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface TicketService {
    Ticket bookTicket(UUID userId, List<UUID> showSeatIds, UUID showId);
    Ticket cancelTicket(UUID ticketId);
    Ticket transferTicket(UUID ticketId, UUID fromUserId, UUID toUserId);
    List<Ticket> getAllTicketsByUserId(UUID userId);
}
