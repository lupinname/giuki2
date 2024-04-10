package ok;

public class Truck extends Vehicle {
    protected double loadWeight;

    public Truck(String ID, String brand, int publishYear, double price, String color, double loadWeight) {
        super(ID, brand, publishYear, price, color, color);
        this.loadWeight = loadWeight;
    }

    public double getLoadWeight() {
		return loadWeight;
	}

	public void setLoadWeight(double loadWeight) {
		this.loadWeight = loadWeight;
	}

	@Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Load Weight: " + loadWeight);
    }
}