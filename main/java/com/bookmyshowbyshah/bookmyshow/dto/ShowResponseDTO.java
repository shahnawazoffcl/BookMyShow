package com.bookmyshowbyshah.bookmyshow.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public class ShowResponseDTO {
    private UUID id;
    @JsonFormat(pattern = "HH:mm:ss", timezone = "Asia/Kolkata")
    private Date startTime;
    @JsonFormat(pattern = "HH:mm:ss", timezone = "Asia/Kolkata")
    private Date endTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date showDate;
    private String movieName;
    private String theatreName;
    private UUID theatreId;
//    private Long screenId;

    @Override
    public String toString() {
        return "Show Date=" + this.getShowDate() + ", Start Time=" + this.getStartTime() + ", End Time=" + this.getEndTime();
    }
}
