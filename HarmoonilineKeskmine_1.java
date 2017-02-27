public class HarmoonilineKeskmine_1{
	
	//double[] kiirused;

	/*public double aritmKeskminePoord(double[] kiirused) {
		double summa = 0;
		for (double a : kiirused){
			summa += 1 / a;
		}
	}*/

/*	public double HarmoonilineKeskmine(double kiirus1, double kiirus2) {
		this.kiirus1 = kiirus1; this.kiirus2 = kiirus2;
	}
*/
	//double keskmine;
	public static double aritmKeskminePoord(double kiirus1, double kiirus2) {
		return  2 / (1/kiirus1 + 1/kiirus2);
	}

	public static void main(String[] args) {
		System.out.println(aritmKeskminePoord(10.0, 20.0));
	}
}