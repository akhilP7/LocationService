package com.schedule.appointment.LocationService.controller;

import com.schedule.appointment.LocationService.model.LocationRequest;
import com.schedule.appointment.LocationService.model.LocationResponse;
import com.schedule.appointment.LocationService.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<Long> addLocation(@RequestBody LocationRequest locationRequest){

        long locationId = locationService.addLocation(locationRequest);
        return new ResponseEntity<>(locationId, HttpStatus.OK);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<LocationResponse> getLocation(@PathVariable ("locationId") long locationId){

        LocationResponse locationResponse = locationService.getLocationById(locationId);
        return new ResponseEntity<>(locationResponse,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LocationResponse>> getLocations(){

        List<LocationResponse> locationResponse = locationService.findAll();
        return new ResponseEntity<>(locationResponse,HttpStatus.OK);
    }
}
