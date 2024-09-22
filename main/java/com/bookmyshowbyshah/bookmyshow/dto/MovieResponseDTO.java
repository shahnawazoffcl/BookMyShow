package com.bookmyshowbyshah.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class MovieResponseDTO {
    private UUID id;
    private String name;
    private String title;
    private String description;
    private String language;
    private String releaseDate;
    private int durationInMinutes;
    private String posterUrl;
}
