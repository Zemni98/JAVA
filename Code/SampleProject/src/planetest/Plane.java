package planetest;

public abstract class Plane {
	private String planeName;
	private int fuelSize;

	public Plane() {

	}

	public Plane(String planceName, int fuelSize) {
		this.planeName = planceName;
		this.fuelSize = fuelSize;
	}

	public void refuel(int fuel) {
		fuelSize += fuel;
		// this.setFuelSie(this.getFuelSie() + fuel);
	}

	public abstract void flight(int distance);

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}

	@Override
	public String toString() {
		return "\t" + planeName + "\t" + fuelSize;
	}

}