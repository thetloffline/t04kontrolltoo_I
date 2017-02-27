public class HarmoonilineKeskmine_1{
	
	public static double aritmKeskminePoord(double kiirus1, double kiirus2) {
		return  2 / (1/kiirus1 + 1/kiirus2);
	}

	public static void main(String[] args) {
		System.out.println(aritmKeskminePoord(10.0, 20.0));
	}
}