package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entity.VehicleSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface VehicleSubCategoryRepository extends JpaRepository<VehicleSubcategory,Long>{
      @Query("select r from VehicleSubcategory r where r.vehicleSubcategoryName = :vehicleSubcategoryName")
    VehicleSubcategory findByCategoryName(String vehicleSubcategoryName);
}
