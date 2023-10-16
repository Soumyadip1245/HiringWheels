package org.ncu.hirewheels.service.adminService;

import java.util.List;

import org.ncu.hirewheels.entity.*;
import org.ncu.hirewheels.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    VehicleSubCategoryRepository categoryRepository;
    @Autowired
    FuelTypeRepository fuelRepository;
    @Autowired
    LocationRepository locationRepository;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        VehicleSubcategory category = categoryRepository
                .findByCategoryName(vehicle.getVehicleSubcategory().getVehicleSubcategoryName());
        FuelType fuel = fuelRepository.findByFuelType(vehicle.getFuelType().getFuelType());
        Location location = locationRepository.findByLocationName(vehicle.getLocation().getLocationName());
        if (category == null || fuel == null || location == null) {

        }
        vehicle.setVehicleSubcategory(category);
        vehicle.setFuelType(fuel);
        vehicle.setLocation(location);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        Vehicle vehicleData = vehicleRepository.findById(vehicle.getVehicleId()).orElse(null);
        if (vehicleData == null) {
            throw new EntityNotFoundException("Vehicle not found");
        }
        int value = vehicleData.getAvailabilityStatus() == 1 ? 0 : 1;
        vehicleData.setAvailabilityStatus(value);
        Vehicle updated = vehicleRepository.save(vehicleData);
        return updated;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles;
    }

    @Override
    public List<Vehicle> getAllVehiclesByAvailablity(CheckAvailable checkAvailable) {
        String locationName = checkAvailable.getLocationName();
        List<Vehicle> vehicles = vehicleRepository.findByAvailabilityStatusAndLocationName(locationName);
        return vehicles;
    }

}
