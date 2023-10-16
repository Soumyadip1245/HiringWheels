package org.ncu.hirewheels.entity;

import java.util.Date;

public class CheckAvailable {
    private String locationName;
    private Date dropoffDate;
    private Date bookingDate;
    public String getLocationName() {
        return locationName;
    }
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    public Date getDropoffDate() {
        return dropoffDate;
    }
    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }
    public Date getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    
}
