package com.schedule.appointment.LocationService.exception;

public class LocationServiceCustomException extends RuntimeException{

    private String errorCode;

    public LocationServiceCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
