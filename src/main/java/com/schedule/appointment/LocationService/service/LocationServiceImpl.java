package com.schedule.appointment.LocationService.service;

import com.schedule.appointment.LocationService.entity.Location;
import com.schedule.appointment.LocationService.exception.LocationServiceCustomException;
import com.schedule.appointment.LocationService.external.response.ResourceResponse;
import com.schedule.appointment.LocationService.model.LocationRequest;
import com.schedule.appointment.LocationService.model.LocationResponse;
import com.schedule.appointment.LocationService.repository.LocationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Log4j2
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RestTemplate restTemplate;

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

        ResourceResponse resourceResponse =
                restTemplate.getForObject("http://RESOURCE-SERVICE/resource/"+ location.getResourceId(),ResourceResponse.class);


        LocationResponse.ResourceDetails resourceDetails = LocationResponse.ResourceDetails.builder()
                .resourceType(resourceResponse.getResourceType())
                .resourceMeaning(resourceResponse.getResourceMeaning())
                .resourceId(resourceResponse.getResourceId())
                .resourceAvailabilityDate(resourceResponse.getResourceAvailabilityDate())
                .resourceAvailabilityStartTime(resourceResponse.getResourceAvailabilityStartTime())
                .resourceAvailabilityEndTime(resourceResponse.getResourceAvailabilityEndTime())
                .build();

        LocationResponse locationResponse =  LocationResponse.builder()
                .locationId(location.getLocationId())
                .locationMeaning(location.getLocationMeaning())
                .build();

        locationResponse.setResourceDetails(Collections.singletonList(resourceDetails));

        BeanUtils.copyProperties(location,locationResponse);
        return locationResponse;
    }

    @Override
    public List<LocationResponse> findAll() {

        log.info("Retrieving location info for all locationIds");

        List<Location> locations = locationRepository.findAll();
        List<LocationResponse> locationResponses = new ArrayList<>();

        for (Location location : locations) {

            ResourceResponse[] resourceResponse =
                    restTemplate.getForObject("http://RESOURCE-SERVICE/resource",ResourceResponse[].class);

            List<LocationResponse.ResourceDetails> resourceDetailsList = new ArrayList<>();

            if (resourceResponse != null){
                for (ResourceResponse newResourceResponse : resourceResponse){
                    LocationResponse.ResourceDetails resourceDetails = LocationResponse.ResourceDetails.builder()
                            .resourceType(newResourceResponse.getResourceType())
                            .resourceMeaning(newResourceResponse.getResourceMeaning())
                            .resourceId(newResourceResponse.getResourceId())
                            .resourceAvailabilityDate(newResourceResponse.getResourceAvailabilityDate())
                            .resourceAvailabilityStartTime(newResourceResponse.getResourceAvailabilityStartTime())
                            .resourceAvailabilityEndTime(newResourceResponse.getResourceAvailabilityEndTime())
                            .build();

                    resourceDetailsList.add(resourceDetails);
                }
            }

            LocationResponse locationResponse =  LocationResponse.builder()
                    .locationId(location.getLocationId())
                    .locationMeaning(location.getLocationMeaning())
                    .resourceDetails(resourceDetailsList)
                    .build();

            BeanUtils.copyProperties(location, locationResponse);
            locationResponses.add(locationResponse);
        }

        return locationResponses;
    }
}
