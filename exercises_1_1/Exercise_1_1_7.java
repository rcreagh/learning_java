// Toy program that runs a while loop.

public class Exercise_1_1_7{
	public static void main(String[] args){
		double t = 9.0;
		while (Math.abs(t - 9.0/t) > 0.001){
			t = (9.0/t + t);
			System.out.printf("%.5f\n", t);
		}
	}
}
