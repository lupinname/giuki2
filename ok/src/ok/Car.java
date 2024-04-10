package ok;

public class Car extends Vehicle {
    protected int slots;
    protected String engineType;

    public Car(String ID, String brand, int publishYear, double price, String color, int slots, String engineType) {
        super(ID, brand, publishYear, price, color, engineType);
        this.slots = slots;
        this.engineType = engineType;
    }

    public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	@Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Slots: " + slots);
        System.out.println("Engine Type: " + engineType);
    }
}
