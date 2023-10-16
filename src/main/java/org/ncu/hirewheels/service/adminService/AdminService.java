package org.ncu.hirewheels.service.adminService;

import java.util.List;

import org.ncu.hirewheels.entity.CheckAvailable;
import org.ncu.hirewheels.entity.Vehicle;

public interface AdminService {
     Vehicle createVehicle(Vehicle vehicle);
     Vehicle updateVehicle(Vehicle vehicle);
     List<Vehicle> getAllVehicles();
     List<Vehicle> getAllVehiclesByAvailablity(CheckAvailable checkAvailable);
}
