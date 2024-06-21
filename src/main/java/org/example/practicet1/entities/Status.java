package org.example.practicet1.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Status {
    @JsonProperty("token")
    private String token;

    @JsonProperty("status")
    private String status;
}
