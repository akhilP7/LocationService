package com.schedule.appointment.LocationService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationResponse {

    private long locationId;
    private String locationMeaning;
    private List<ResourceDetails> resourceDetails;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResourceDetails {

        private long resourceId;
        private String resourceType;
        private String resourceMeaning;
        private LocalDate resourceAvailabilityDate;
        private LocalTime resourceAvailabilityStartTime;
        private LocalTime resourceAvailabilityEndTime;
    }

}
