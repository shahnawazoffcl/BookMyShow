package com.bookmyshowbyshah.bookmyshow.dto;

import com.bookmyshowbyshah.bookmyshow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserSignUpResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private int responseCode;
    private String responseMessage;
    private List<Ticket> tickets; //TODO:change to TicketResponseDTO
}
