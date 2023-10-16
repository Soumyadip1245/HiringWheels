package org.ncu.hirewheels.entity;
import java.math.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_subcategory")
public class VehicleSubcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_subcategory_id")
    private Long vehicleSubcategoryId;

    @Column(name = "vehicle_subcategory_name", nullable = false, unique = true)
    private String vehicleSubcategoryName;

    @Column(name = "price_per_day", nullable = false)
    private BigDecimal pricePerDay;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_category_id")
    private VehicleCategory vehicleCategory;

    @OneToMany(mappedBy = "vehicleSubcategory",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Vehicle> vehicle;

    public Long getVehicleSubcategoryId() {
        return vehicleSubcategoryId;
    }

    @Override
    public String toString() {
        return "VehicleSubcategory [vehicleSubcategoryId=" + vehicleSubcategoryId + ", vehicleSubcategoryName="
                + vehicleSubcategoryName + ", pricePerDay=" + pricePerDay + ", vehicleCategory=" + vehicleCategory
                + ", vehicle=" + vehicle + "]";
    }

    public void setVehicleSubcategoryId(Long vehicleSubcategoryId) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
    }

    public String getVehicleSubcategoryName() {
        return vehicleSubcategoryName;
    }

    public void setVehicleSubcategoryName(String vehicleSubcategoryName) {
        this.vehicleSubcategoryName = vehicleSubcategoryName;
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

  
   
}
