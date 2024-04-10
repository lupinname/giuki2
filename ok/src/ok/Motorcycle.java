package ok;

public class Motorcycle extends Vehicle {
    protected int capacity;

    public Motorcycle(String ID, String brand, int publishYear, double price, String color, int capacity) {
        super(ID, brand, publishYear, price, color, color);
        this.capacity = capacity;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Capacity: " + capacity);
    }

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
