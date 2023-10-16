package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface LocationRepository extends JpaRepository<Location,Long>{
    @Query("select u from Location u where u.locationName = :locationName")
    public Location findByLocationName(@Param("locationName") String locationName);
}
