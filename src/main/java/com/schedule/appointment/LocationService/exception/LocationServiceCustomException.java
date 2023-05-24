package com.schedule.appointment.LocationService.exception;

import lombok.Data;

@Data
public class LocationServiceCustomException extends RuntimeException{

    private String errorCode;

    public LocationServiceCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
