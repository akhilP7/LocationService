package com.schedule.appointment.LocationService.repository;

import com.schedule.appointment.LocationService.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long>{
}
