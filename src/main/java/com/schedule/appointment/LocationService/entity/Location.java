package com.schedule.appointment.LocationService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LOCATION")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationId;

    @Column(name = "LOCATION_MEANING")
    private String locationMeaning;

    @Column(name = "RESOURCE_ID")
    private String resourceId;
}
