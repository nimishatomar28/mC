package com.company.cabBooking.models;

public class Driver {
    private String driver_name;
    private Location driver_location;
    boolean isAvailable;
    String gender;
    String age;
    Vehicle vehicle;
    int totalEarnings;

    public Driver(String driver_name, Location driver_location, boolean isAvailable, String gender, String age, Vehicle vehicle,int totalEarnings)
    {
        this.driver_name     = driver_name;
        this.driver_location = driver_location;
        this.isAvailable     = isAvailable;
        this.gender          = gender;
        this.age             = age;
        this.vehicle         = vehicle;
        this.totalEarnings   = totalEarnings;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public Location getDriver_location() {
        return driver_location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public void setDriver_location(Location driver_location) {
        this.driver_location = driver_location;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings = totalEarnings;
    }
}
