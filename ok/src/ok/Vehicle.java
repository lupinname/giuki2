package ok;

 public class Vehicle implements ICar {
    protected String ID;
    protected String brand;
    protected int publishYear;
    protected double price;
    protected String color;
    protected String vehicleType;

    public Vehicle(String ID, String brand, int publishYear, double price, String color, String vehicleType) {
        this.ID = ID;
        this.brand = brand;
        this.publishYear = publishYear;
        this.price = price;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Brand: " + brand);
        System.out.println("Publish Year: " + publishYear);
        System.out.println("Price: " + price);
        System.out.println("Color: " + color);
    }
}