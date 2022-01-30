package com.company.cabBooking;

import com.company.cabBooking.models.*;

import java.util.*;

public class RideManager {
    List<Driver> availableDriverList;
    Map<String, Integer> driverEarningList;
    Map<String, List<Driver>> possibleDriverList;
    List<Driver> allDriverList;
    List<User> userList;

    public RideManager() {
        availableDriverList = new ArrayList<>();
        allDriverList = new ArrayList<>();
        driverEarningList = new HashMap<>();
        userList = new ArrayList<User>();
        possibleDriverList = new HashMap<>();
    }

    void addUser(String name, String gender, String age) {
        Location location = new Location(0, 0);
        User newUser = new User(name, location, location, "", gender, age);
        userList.add(newUser);
    }

    void addDriver(String name, String gender, String age, Vehicle vehicleDetails, Location location) {
        Driver newDriver = new Driver(name, location, true, gender, age, vehicleDetails, 0);
        allDriverList.add(newDriver);
        availableDriverList.add(newDriver);
    }

    void updateUserLocation(String name, Location location) {
        for (User user : userList) {
            if (user.getUser_name().equals(name)) {
                user.setUser_location_source(location);
                break;
            }
        }
    }

    void updateDriverLocation(String name, Location location) {
        for (Driver driver : allDriverList) {
            if (driver.getDriver_name().equals(name)) {
                driver.setDriver_location(location);
                break;
            }
        }
    }

    void changeDriverStatus(String name, boolean status) {
        for (Driver driver : allDriverList) {
            if (driver.getDriver_name().equals(name)) {
                driver.setAvailable(status);
                if (status)
                    availableDriverList.add(driver);
                break;
            }
        }
    }

    List<Driver> findRide(String userName, Location source, Location destination) {
        //List<Driver>possibleDriverList = new ArrayList<Driver>();
        possibleDriverList.putIfAbsent(userName, new ArrayList<>());
        /*for (Driver driver : availableDriverList)
        {
            System.out.println(driver.getDriver_location().getX()+" "+driver.getDriver_location().getY());
        }*/
        int s1, s2, d1, d2;
        double dist;
        s1 = source.getX();
        d1 = source.getY();
        for(User user: userList)
        {
            if(user.getUser_name().equals(userName))
            {
                user.setUser_location_destination(destination);
            }
        }

        for (Driver driver : availableDriverList) {
            Location driverLocation = driver.getDriver_location();
            s2 = driverLocation.getX();
            d2 = driverLocation.getY();
            dist = Math.sqrt(Math.pow((d2 - d1), 2) + Math.pow((s2 - s1), 2));
            if (dist <= 5)
                possibleDriverList.get(userName).add(driver);
        }
        for (Map.Entry<String, List<Driver>> mp : possibleDriverList.entrySet()) {
            if ((mp.getKey() == userName) && (mp.getValue().isEmpty())) {
                System.out.println("No driver is available");
            }
        }
        return possibleDriverList.get(userName);
    }

    String chooseRide(String userName, String driverName) {
        for (Map.Entry<String, List<Driver>> mp : possibleDriverList.entrySet()) {
            if (!mp.getValue().isEmpty()) {
                for (Driver driver : possibleDriverList.get(userName)) {
                    if (driver.getDriver_name().equals(driverName)) {
                        if (driver.isAvailable()) {
                            driver.setTotalEarnings(driver.getTotalEarnings() + calculateBill(userName));
                            return driverName;
                        } else {
                            System.out.println("This driver is not available anymore");
                        }
                    }
                }
            }
        }
        return "";
    }

    int calculateBill(String userName) {
        int s1, d1, s2, d2, billAmt;

        double dist;
        int value;
        for (User user : userList) {
            if (user.getUser_name().equals(userName)) {
                s1 = user.getUser_location_source().getX();
                d1 = user.getUser_location_source().getY();
                s2 = user.getUser_location_destination().getX();
                d2 = user.getUser_location_destination().getY();
                dist = Math.sqrt(Math.pow((d2 - d1), 2) + Math.pow((s2 - s1), 2));

                System.out.println(s1+" "+d1+" "+s2+" "+d2+" "+dist);
                value = (int) Math.round(dist);
                if(dist > value)
                    return value+1;
                return value;
            }
        }
        return 0;
    }

    void findTotalEarning() {
        for (Driver driver : allDriverList) {
            System.out.println(driver.getDriver_name() + " earn " + driver.getTotalEarnings());
        }
    }

}
