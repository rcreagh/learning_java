//Program that returns true if a passed in number is between 0 and 1.

public class Exercise_1_1_5{
	public static boolean check_value(double a){
		if(a <= 1 && a >= 0){
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args){
		double a = Double.parseDouble(args[0]);
		if (check_value(a)){
			System.out.println("True");
		}
		else{
			System.out.println("False");
		}
	}
}
