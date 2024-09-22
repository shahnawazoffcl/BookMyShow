package com.bookmyshowbyshah.bookmyshow.client;

import com.bookmyshowbyshah.bookmyshow.dto.ErrorResponseDTO;
import com.bookmyshowbyshah.bookmyshow.dto.SessionStatus;
import com.bookmyshowbyshah.bookmyshow.dto.ValidateTokenDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class UserServiceClient {
    private final RestTemplateBuilder restTemplateBuilder;

    @Value("${userService.base.url}")
    private String userServiceBaseURL;
    @Value("${userService.validate.path}")
    private String validateTokenPath;

    public UserServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public SessionStatus validateToken(ValidateTokenDTO validateTokenDTO){
        String userServiceUrl = userServiceBaseURL + validateTokenPath;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> result = restTemplate.postForEntity(userServiceUrl, validateTokenDTO, String.class);
        System.out.println(result.getBody());

        return result.getBody().contains("ACTIVE") ?SessionStatus.ACTIVE : SessionStatus.ENDED;
    }
}
