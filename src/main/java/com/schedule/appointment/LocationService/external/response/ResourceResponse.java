package com.schedule.appointment.LocationService.external.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResourceResponse {

    private long resourceId;
    private String resourceType;
    private String resourceMeaning;
    private LocalDate resourceAvailabilityDate;
    private LocalTime resourceAvailabilityStartTime;
    private LocalTime resourceAvailabilityEndTime;
}
