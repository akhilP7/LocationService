package com.schedule.appointment.LocationService.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResourceServiceCustomException extends RuntimeException{

    private String errorCode;

    public ResourceServiceCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
