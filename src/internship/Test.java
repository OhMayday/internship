package internship;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter in the equation for which you want the derivative (Make sure there are spaces between operators! Also use x for your variable)");
		String P = scan.nextLine();
		System.out.println(P);
		String[] P1 = P.split("\\s+");
		String[] P1D = new String[P1.length];
		/*for (int lcv = 0; lcv < P1.length; lcv++)
		{
			System.out.println(P1[lcv]);
		}*/
		for (int lcv = 0; lcv < P1.length; lcv++)
		{
			if (P1[lcv].contains("x"))
			{
				int sl = 0;
				int ix = P1[lcv].indexOf("x");
				int car = P1[lcv].indexOf("^");
				if (P1[lcv].charAt(0) == 'x')	
				{
					sl = 1;
				}
				else
				{
					sl = Integer.valueOf(P1[lcv].substring(0, ix));

				}
				if (car > -1)
				{
					int pow = (Integer.valueOf(P1[lcv].substring(ix+2, ix+3)));	
					sl = sl * pow;
					P1D[lcv] = sl + "x^" + (pow - 1);
				}
				else
				{
					P1D[lcv] = sl + "";
				}
				
			}
			else if (P1[lcv].matches("[+-]"))
			{
				if (P1[lcv+1].contains("x"))
				{
					P1D[lcv] = P1[lcv];
				}
				else
				{
					P1D[lcv] = "";
					P1D[lcv+1] = "";
				}
			}
			
			
		}
		
		
		
		//displaying the final array
		for (int lcv = 0; lcv < P1D.length; lcv++)
		{
			System.out.print((P1D[lcv]) + " ");
		}
	}

}
