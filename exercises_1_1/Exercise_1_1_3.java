public class Exercise_1_1_3{
	public static void main(String[] args){
		if(args.length != 3){
			System.out.println("Error: Requires 3 integers");
		}
		else{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = Integer.parseInt(args[2]);
			if(a == b && b == c){
				System.out.println("equal");
			}
			else{
				System.out.println("not equal");
			}
		}
	}
}
