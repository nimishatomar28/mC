package com.company.cabBooking.models;

public class Vehicle {
    private String car_name;
    private String car_no;

    public Vehicle(String car_name, String car_no)
    {
        this.car_name = car_name;
        this.car_no   = car_no;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_no() {
        return car_no;
    }

    public void setCar_no(String car_no) {
        this.car_no = car_no;
    }
}
