package com.company.cabBooking;
import com.company.cabBooking.models.*;

import java.util.ArrayList;
import java.util.List;

public class DriverClass {
    public static void main(String[] args) {
	    List<Driver>dList = new ArrayList<Driver>();
        Location location       = new Location(0,0);
        Location source         = new Location(0,0);
        Location destination    = new Location(0,0);
        Vehicle  vehicle        = new Vehicle("","");
        RideManager rideManager = new RideManager();
        String driver;

        rideManager.addUser("Abhishek", "M", "23");
        /*location.setX(0);
        location.setY(0);*/

        rideManager.updateUserLocation("Abhishek",new Location(0,0));
        rideManager.addUser("Rahul", "M", "29");

        /*location.setX(10);
        location.setY(0);*/
        rideManager.updateUserLocation("Rahul",new Location(10,0));
        rideManager.addUser("Nandini", "F", "22");
        /*location.setX(15);
        location.setY(6);*/
        rideManager.updateUserLocation("Nandini",new Location(15,6));


        location.setX(10);
        location.setY(1);
        vehicle.setCar_name("Swift");
        vehicle.setCar_no("KA-01-12345");
        rideManager.addDriver("Driver1", "M", "22",vehicle,location);

        location = new Location(11,10);
        //location.setX(11);
        //location.setY(10);
        vehicle.setCar_name("Swift");
        vehicle.setCar_no("KA-01-12345");
        rideManager.addDriver("Driver2", "M", "29",vehicle,location);

        location = new Location(5,3);
        //location.setX(5);
        //location.setY(3);
        vehicle.setCar_name("Swift");
        vehicle.setCar_no("KA-01-12345");
        rideManager.addDriver("Driver3", "M", "24",vehicle,location);

       /*source.setX(0);
        source.setY(0);
        destination.setX(20);
        destination.setY(1);*/

        dList = rideManager.findRide("Abhishek",new Location(0,0),new Location(20,1));
        if(!dList.isEmpty())
        {
            driver = rideManager.chooseRide("Abhishek","Driver1");
            if(!driver.isEmpty())
                System.out.println(driver);
        }
        else
        {
            driver = rideManager.chooseRide("Abhishek","Driver1");
        }

        /*source.setX(10);
        source.setY(0);
        destination.setX(5);
        destination.setY(3);*/

        dList = rideManager.findRide("Rahul",new Location(10,0),new Location(5,3));
        if(!dList.isEmpty())
        {
            for(Driver d : dList)
            {
                System.out.println(d.getDriver_name()+"[Available] ");
            }
            driver = rideManager.chooseRide("Rahul","Driver1");
            if(!driver.isEmpty())
            {
                System.out.println("ride started with "+driver);
                System.out.println("ride ended with Bill Amt: "+rideManager.calculateBill("Rahul"));
            }
        }
        else
        {
            driver = rideManager.chooseRide("Rahul","Driver1");
        }
        rideManager.findTotalEarning();

        rideManager.updateUserLocation("Rahul",new Location(15,3));
        rideManager.updateDriverLocation("Driver1",new Location(15,3));
        rideManager.updateDriverLocation("Driver2",new Location(15,3));
        dList = rideManager.findRide("Nandini",new Location(15,6),new Location(20,4));
        if(!dList.isEmpty())
        {
            for(Driver d : dList)
            {
                System.out.println(d.getDriver_name()+"[Available] ");
            }
            driver = rideManager.chooseRide("Nandini","Driver2");
            if(!driver.isEmpty())
            {
                System.out.println("ride started with "+driver);
                System.out.println("ride ended with Bill Amt: "+rideManager.calculateBill("Nandini"));
            }
        }
        else
        {
            driver = rideManager.chooseRide("Rahul","Driver1");
        }
        //change_driver_status(“Driver1”,False)

        rideManager.findTotalEarning();
    }
}
