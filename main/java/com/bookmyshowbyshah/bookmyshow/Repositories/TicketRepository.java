package com.bookmyshowbyshah.bookmyshow.Repositories;

import com.bookmyshowbyshah.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {

    public List<Ticket> findAllByUserId(UUID userId);
}
