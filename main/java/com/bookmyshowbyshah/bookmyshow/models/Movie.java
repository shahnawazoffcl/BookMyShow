package com.bookmyshowbyshah.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel implements Serializable {
    private String name;
    private String title;
    private String description;
    private int durationInMinutes;
    private String language;
    private String posterUrl;
    private String releaseDate;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Genre> genres;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
}
