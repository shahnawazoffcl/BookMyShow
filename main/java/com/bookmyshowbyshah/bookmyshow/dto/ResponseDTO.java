package com.bookmyshowbyshah.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDTO {
    private String message;
    private String messageCode;
    private List<MovieResponseDTO> movies;
}
