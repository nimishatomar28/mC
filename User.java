package com.company.cabBooking.models;

public class User {
    private String user_name;
    private Location user_location_source;
    private Location user_location_destination;
    String contact_no;
    String gender;
    String age;

    public User(String user_name, Location user_location_source, Location user_location_destination, String contact_no, String gender, String age)
    {
        this.user_name                 = user_name;
        this.user_location_source      = user_location_source;
        this.user_location_destination = user_location_destination;
        this.contact_no                = contact_no;
        this.gender                    = gender;
        this.age                       = age;
    }

    public String getUser_name() {
        return user_name;
    }

    public Location getUser_location_source() {
        return user_location_source;
    }

    public Location getUser_location_destination() {
        return user_location_destination;
    }

    public String getContact_no() {
        return contact_no;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_location_source(Location user_location_source) {
        this.user_location_source = user_location_source;
    }

    public void setUser_location_destination(Location user_location_destination) {
        this.user_location_destination = user_location_destination;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
