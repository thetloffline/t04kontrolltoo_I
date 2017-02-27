public class HarmoonilineKeskmine_2{
	public static double[] kiirused = {10, 30, 59, 77, 88};

	public static double jadaSumma(double[] input) {
		double summa = 0;
		for(double a : input){
			summa += 1 / a;
		}
		return summa;
	}

	public static double jadaKeskmiseArvutamine(double[] input) {
		return input.length / jadaSumma(input);		
	}

	public static void main(String[] args) {
		System.out.println(jadaKeskmiseArvutamine(kiirused));
		
	}

}