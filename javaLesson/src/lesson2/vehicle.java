package lesson2;

public class vehicle {
	public String name;
	public float tank;
	public float oilConsumption;
	public vehicle(String n, float t, float oilCon) {
		this.name = n;
		this.tank = t;
		this.oilConsumption = oilCon;
	}
	public void gas(float g) {
		this.tank += g;
	}
	public void run() {
		System.out.println("I'm running now");
	}
	public static void main(String[] args) {
		vehicle car1 = new vehicle("dazhong", 50, 5);
		vehicle car2 = new vehicle("qiya", 60, 6);
		car1.run();
	}
}
