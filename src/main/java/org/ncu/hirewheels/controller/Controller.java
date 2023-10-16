package org.ncu.hirewheels.controller;

import java.util.List;
import java.util.Map;

import org.ncu.hirewheels.entity.*;
import org.ncu.hirewheels.service.adminService.AdminService;
import org.ncu.hirewheels.service.bookingService.BookingService;
import org.ncu.hirewheels.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    BookingService bookingService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        User user = userService.getUserByEmail(email);

        if (user == null) {
            return new ResponseEntity<>("User Not Found In Database", HttpStatus.UNAUTHORIZED);
        } else {
            if (user.getPassword().equals(password)) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Unauthorized User", HttpStatus.UNAUTHORIZED);
            }
        }
    }

    @PostMapping("/registerVehicle")
    public Vehicle registerVehicle(@RequestBody Vehicle vehicle) {
        return adminService.createVehicle(vehicle);
    }

    @PostMapping("/updateAvailabiltity")
    public Vehicle updateAvailability(@RequestBody Vehicle vehicle) {
        return adminService.updateVehicle(vehicle);
    }

    @GetMapping("/vehicles")
    public List<Vehicle> Vehicles() {
        return adminService.getAllVehicles();
    }

    @PostMapping("/availableVehicles")
    public List<Vehicle> availableVehicles(@RequestBody CheckAvailable checkAvailable) {
        return adminService.getAllVehiclesByAvailablity(checkAvailable);
    }

    @PostMapping("/booking")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
}
