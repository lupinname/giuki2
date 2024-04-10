package ok;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



interface ICar {
    void showInfo();
}


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    public static void main(String[] args) {
    
        while (true) {
        	System.out.println("------------Menu------------");
            System.out.println("\n1. Add a vehicle");
            System.out.println("2. Delete a vehicle");
            System.out.println("3. update vehicle");
            System.out.println("4. Show all vehicles");
            System.out.println("5. Write to file");
            System.out.println("6. Read from file");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                	createVehicle();
                    break;
                case 2:
                	deleteVihicle();
                    break;
                case 3:
                	updateVehicle();
                    break;
                case 4:
                    for (ICar vehicle : vehicles) {
                        vehicle.showInfo();
                    }
                    break;
                case 5:
                    writeToTextFile(vehicles);
                    break;
                case 6:
                    readFromTextFile(vehicles);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void createVehicle() {
        System.out.print("Enter ID vehicle: ");
        String ID = scanner.nextLine();
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter publish year: ");
        int publishYear = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Vehicle Type (Car/Motorcycle/Truck): ");
        String vehicleType = scanner.nextLine();
        Vehicle vehicle = null;
        switch (vehicleType.toLowerCase()) {
            case "car":
            	System.out.print("Enter number of slots: ");
                int slots = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter engine type: ");
                String engineType = scanner.nextLine();
                 vehicle = new Car(ID, brand, publishYear, price, color, slots, engineType);
                break;
            case "motorcycle":
            	System.out.print("Enter capacity: ");
                int capacity = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                vehicle = new Motorcycle(ID, brand, publishYear, price, color, capacity);
                break;
            case "truck":
            	System.out.print("Enter load weight: ");
                double loadWeight = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                vehicle = new Truck(ID, brand, publishYear, price, color, loadWeight);
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }vehicles.add(vehicle);
        
        System.out.println("Employee created successfully.");
        
    }
    
    //delleted
    private static void deleteVihicle() {
        System.out.print("Enter ID of Vehicle to delete: ");
        String ID = scanner.nextLine();
        boolean removed = vehicles.removeIf (vehicles -> vehicles.ID.equals(ID));
        if (removed) {
            System.out.println("Vehicle deleted successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }
     // update
    private static void updateVehicle() {
        System.out.print("Enter ID of employee to update: ");
        String ID = scanner.nextLine();
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.ID.equals(ID)) {
                System.out.println("Vehicle found. Enter new information:");
                System.out.print("Enter Brand: ");
                vehicle.brand = scanner.nextLine();
                System.out.print("Enter publishYear: ");
                vehicle.publishYear = scanner.nextInt();
                System.out.print("Enter Price: ");
                vehicle.price = scanner.nextInt();
                System.out.print("Enter Color: ");
                vehicle.color = scanner.nextLine();
                System.out.print("Enter Employee Type (Experience/Fresher/Intern): ");
                vehicle.vehicleType = scanner.nextLine();
                switch (vehicle.vehicleType.toLowerCase()) {
                    case "car":
                        System.out.print("Enter number of slots : ");
                        ((Car) vehicle).setSlots(scanner.nextInt());
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter engine Type: ");
                        ((Car) vehicle).setEngineType(scanner.nextLine());
                        break;
                    case "motorcycle":
                        System.out.print("Enter capacity : ");
                        ((Motorcycle) vehicle).setCapacity(scanner.nextInt());
                        break;
                    case "truck":
                        System.out.print("Enter load weight : ");
                        ((Truck) vehicle).setLoadWeight(scanner.nextDouble());
                     
                        break;
                    default:
                        System.out.println("Invalid employee type.");
                        return;
                }
                System.out.println("Employee updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }
    }
    private static void writeToTextFile(ArrayList<Vehicle> vehicless) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("vehicles.txt"))) {
            for (ICar vehicle : vehicles) {
                if (vehicle instanceof Car) {
                    Car car = (Car) vehicle;
                    writer.println("Car," + car.ID + "," + car.brand + "," + car.publishYear + "," + car.price + "," + car.color + "," + car.slots + "," + car.engineType);
                } else if (vehicle instanceof Motorcycle) {
                    Motorcycle motorcycle = (Motorcycle) vehicle;
                    writer.println("Motorcycle," + motorcycle.ID + "," + motorcycle.brand + "," + motorcycle.publishYear + "," + motorcycle.price + "," + motorcycle.color + "," + motorcycle.capacity);
                } else if (vehicle instanceof Truck) {
                    Truck truck = (Truck) vehicle;
                    writer.println("Truck," + truck.ID + "," + truck.brand + "," + truck.publishYear + "," + truck.price + "," + truck.color + "," + truck.loadWeight);
                }
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readFromTextFile(ArrayList<Vehicle> vehicless) {
        try (BufferedReader reader = new BufferedReader(new FileReader("vehicles.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 7) {
                    if (parts[0].equals("Car")) {
                        vehicles.add(new Car(parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), parts[5], Integer.parseInt(parts[6]), parts[7]));
                    } else if (parts[0].equals("Motorcycle")) {
                        vehicles.add(new Motorcycle(parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), parts[5], Integer.parseInt(parts[6])));
                    } else if (parts[0].equals("Truck")) {
                        vehicles.add(new Truck(parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), parts[5], Double.parseDouble(parts[6])));
                    }
                }
            }
            System.out.println("Data read from file successfully.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
