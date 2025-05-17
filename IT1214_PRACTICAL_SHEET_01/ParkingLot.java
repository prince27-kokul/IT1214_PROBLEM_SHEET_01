import java.util.*;
class Vehicle 
{
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    public Vehicle(String licensePlate, String ownerName, int hoursParked) 
	{
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    public String getLicensePlate() 
	{
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) 
	{
        this.licensePlate = licensePlate;
    }

    public String getOwnerName() 
	{
        return ownerName;
    }

    public void setOwnerName(String ownerName) 
	{
        this.ownerName = ownerName;
    }

    public int getHoursParked() 
	{
        return hoursParked;
    }

    public void setHoursParked(int hoursParked) 
	{
        this.hoursParked = hoursParked;
    }

    
    public String toString() 
	{
        return "License Plate: " + licensePlate + ", Owner: " + ownerName + ", Hours Parked: " + hoursParked;
    }
}
class ParkingLot 
{
    private Vehicle[] vehicles;
    private int vehicleCount;

    public ParkingLot() 
	{
        vehicles = new Vehicle[5];
        vehicleCount = 0;
    }

    public void parkVehicle(Vehicle vehicle) 
	{
        if (vehicleCount < vehicles.length) 
		{
            vehicles[vehicleCount++] = vehicle;
        } else {
            System.out.println("Parking lot is full. Cannot park more vehicles.");
        }
    }

    public void removeVehicle(String licensePlate) 
	{
        boolean found = false;
        for (int i = 0; i < vehicleCount; i++) 
		{
            if (vehicles[i].getLicensePlate().equalsIgnoreCase(licensePlate)) 
			{
                // Shift vehicles to remove gap
                for (int j = i; j < vehicleCount - 1; j++) 
				{
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[vehicleCount - 1] = null;
                vehicleCount--;
                found = true;
                System.out.println("Vehicle with license plate " + licensePlate + " removed.");
                break;
            }
        }
        if (!found) 
		{
            System.out.println("Vehicle with license plate " + licensePlate + " not found.");
        }
    }

    public void displayVehicles() 
	{
        System.out.println("Parked Vehicles:");
        for (int i = 0; i < vehicleCount; i++) 
		{
            System.out.println(vehicles[i]);
        }
    }
}
class Main 
{
    public static void main(String[] args) 
	{
        ParkingLot lot = new ParkingLot();

        lot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        lot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        lot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));

        lot.removeVehicle("XYZ789");

        lot.displayVehicles();
    }
}