package com.rafael.pizzeria.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    public String type;
    public String message;
    private Long code;
    private ZonedDateTime timestamp;
}
