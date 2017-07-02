// Program that takes an int n and returns the largest int not larger than the
// base-2 logarithm of n, without using the Math library.

public class Exercise_1_1_13{
	public static double power(double a, int pow){
		double val = a;
		for (int i = 1; i <= pow; i++){
			val *= a;
		}
		return val;
	}
			
	public static double taylor_expansion(int n){
		double expansion = (n - 1.0)/n;
		double estimation = 0.0;
		int iteration = 1;
		while (expansion >= 0.00000000000000000000000001){
			estimation += expansion;
			System.out.println(estimation);
			iteration += 1;
			expansion = (1.0/iteration) * power(((n - 1.0)/n), iteration);
			System.out.println(expansion);
		}
	return estimation;
	}
	
	public static int lg(int n){
		double log_of_n = taylor_expansion(n);
		return (int)log_of_n;
	}
	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);
		System.out.println(lg(n));
	}
}
