package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entity.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface FuelTypeRepository extends JpaRepository<FuelType,Long>{
    @Query("select u from FuelType u where u.fuelType = :fuelType")
    public FuelType findByFuelType(@Param("fuelType") String fuelType);
}
