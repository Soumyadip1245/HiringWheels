package org.ncu.hirewheels.service.bookingService;

import org.ncu.hirewheels.entity.*;
import org.ncu.hirewheels.repository.BookingRepository;
import org.ncu.hirewheels.repository.LocationRepository;
import org.ncu.hirewheels.repository.UserRepository;
import org.ncu.hirewheels.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Booking createBooking(Booking booking) {
        Location location = locationRepository.findByLocationName(booking.getLocation().getLocationName());
        Vehicle vehicle = vehicleRepository.findByvehicleNumber(booking.getVehicle().getVehicleNumber());
        User user = userRepository.findByphoneNumber(booking.getUser().getMobileNo());
        if (location == null) {
            throw new EntityNotFoundException("Location not found");
        }

        if (vehicle == null) {
            throw new EntityNotFoundException("Vehicle not found");
        }

        if (user == null) {
            throw new EntityNotFoundException("User not found");
        }
        booking.setUser(user);
        booking.setVehicle(vehicle);
        booking.setLocation(location);
        return bookingRepository.save(booking);
    }
    
}
