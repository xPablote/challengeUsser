package com.api.rest.models.error;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {
    private List<String> mensajes;
}
