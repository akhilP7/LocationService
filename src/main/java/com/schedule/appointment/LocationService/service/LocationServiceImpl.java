package com.schedule.appointment.LocationService.service;

import com.schedule.appointment.LocationService.entity.Location;
import com.schedule.appointment.LocationService.exception.LocationServiceCustomException;
import com.schedule.appointment.LocationService.model.LocationRequest;
import com.schedule.appointment.LocationService.model.LocationResponse;
import com.schedule.appointment.LocationService.repository.LocationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public long addLocation(LocationRequest locationRequest) {

        log.info("Adding a new location entry....");

        Location location = Location.builder()
                .locationMeaning(locationRequest.getLocationMeaning())
                .resourceId(locationRequest.getResourceId())
                .build();

        locationRepository.save(location);
        return location.getLocationId();
    }

    @Override
    public LocationResponse getLocationById(long locationId) {

        log.info("Retrieving location info by locationId: {}",locationId);

        Location location = locationRepository.findById(locationId)
                .orElseThrow(
                        ()-> new LocationServiceCustomException("Location with given Id is not found","Location not found")
                );

        LocationResponse locationResponse = new LocationResponse();
        BeanUtils.copyProperties(location,locationResponse);
        return locationResponse;
    }

    @Override
    public List<LocationResponse> findAll() {
        List<Location> locations = locationRepository.findAll();
        List<LocationResponse> locationResponses = new ArrayList<>();

        for (Location location : locations) {
            LocationResponse locationResponse = new LocationResponse();
            BeanUtils.copyProperties(location, locationResponse);
            locationResponses.add(locationResponse);
        }

        return locationResponses;
    }
}
