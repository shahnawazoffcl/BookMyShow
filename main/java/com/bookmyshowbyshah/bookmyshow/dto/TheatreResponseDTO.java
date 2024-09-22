package com.bookmyshowbyshah.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TheatreResponseDTO {
    private UUID id;
    private String name;
    private String region;

    public String toString() {
        return "name=" + this.getName() + ",\n region=" + this.getRegion();
    }
}
