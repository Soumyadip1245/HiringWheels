package org.ncu.hirewheels.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_category")
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_category_id")
    private Long vehicleCategoryId;
    @Column(name = "vehicle_category_name", nullable = false, unique = true)
    private String vehicleCategoryName;
    @OneToMany(mappedBy = "vehicleCategory", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<VehicleSubcategory> vehicleSubcategory;

    public Long getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(Long vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategoryName() {
        return vehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
    }

    public List<VehicleSubcategory> getVehicleSubcategory() {
        return vehicleSubcategory;
    }

    public void setVehicleSubcategory(List<VehicleSubcategory> vehicleSubcategory) {
        this.vehicleSubcategory = vehicleSubcategory;
    }

}
