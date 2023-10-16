package org.ncu.hirewheels.repository;

import java.util.List;

import org.ncu.hirewheels.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface VehicleRepository  extends JpaRepository<Vehicle,Long>{
    @Query("SELECT v FROM Vehicle v WHERE v.availabilityStatus = 1 " +
    "AND v.location.locationName = :locationName ")
List<Vehicle> findByAvailabilityStatusAndLocationName(
     @Param("locationName") String locationName);
     @Query("select u from Vehicle u where u.vehicleNumber = :vehicleNumber")
    public Vehicle findByvehicleNumber(@Param("vehicleNumber") String vehicleNumber);

}
