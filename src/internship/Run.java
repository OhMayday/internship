package internship;
import java.util.Scanner;
public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter in the equation for which you want the derivative (Make sure there are spaces between operators! Also use x for your variable)");
		String P = scan.nextLine();
		String Fin = SingleDerivative.Derive(P);
		System.out.println(Fin);
		
	}

}
