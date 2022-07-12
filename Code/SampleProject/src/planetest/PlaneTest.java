package planetest;

public class PlaneTest {
	public static void main(String[] args) {
		Plane airplane = new Airplane("L747", 1000);
		Plane cargoplane = new Cargoplane("C40", 1000);

		System.out.println("\tPlane\tfuelSize");
		System.out.println("----------------------");
		System.out.println(airplane);
		System.out.println(cargoplane);

		airplane.flight(100);
		cargoplane.flight(100);

		System.out.println("\n100 운항\n\tPlane\tfuelSize");
		System.out.println("-----------------------");
		System.out.println(airplane);
		System.out.println(cargoplane);

		airplane.refuel(200);
		cargoplane.refuel(200);

		System.out.println("\n200 주유\n\tPlane\tfuelSize");
		System.out.println("-----------------------");
		System.out.println(airplane);
		System.out.println(cargoplane);
	}
}