package com.bookmyshowbyshah.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class JwtPayloadDTO {
    private String userId;
    private List<String> roles;
    private long createdAt;
    private long expiresAt;
}
