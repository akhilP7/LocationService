package com.schedule.appointment.LocationService.service;

import com.schedule.appointment.LocationService.model.LocationRequest;
import com.schedule.appointment.LocationService.model.LocationResponse;

import java.util.List;

public interface LocationService {
    long addLocation(LocationRequest locationRequest);

    LocationResponse getLocationById(long locationId);

    List<LocationResponse> findAll();
}
