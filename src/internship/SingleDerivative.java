package internship;


public class SingleDerivative {

	String Derive;
	public static String Derive(String P) {
	
			
			String[] P1 = P.split("\\s+");
			String[] P1D = new String[P1.length];

			for (int lcv = 0; lcv < P1.length; lcv++)
			{
				
				if (P1[lcv].contains("("))
				{
					int fin = lcv;
					String P1C = P1[lcv];
					while (P1[lcv].contains(")") != true)
					{
						if (P1[lcv+1].matches("[+-]"))
						{
							P1C = P1C + " " + P1[lcv+1] + " " + P1[lcv+2];
							P1D[lcv+1] = "";
							P1D[lcv+2] = "";					
							lcv = lcv + 2;
						}
					}
					P1D[fin] = chainRule.derive(P1C);
					/*if (P1[lcv+1].matches("[*]"))
					{
						
					}
					else if (P1[lcv+1].matches("[/]"))
					{
						
					}
					else
					{
						P1D[fin] = chainRule.derive(P1C);
					}*/

				}
				else if (P1[lcv].contains("x"))
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
						int pow = (Integer.valueOf(P1[lcv].substring(ix+2, P1[lcv].length())));	
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
			
			
			String Derivative = "";
			//displaying the final array
			for (int lcv = 0; lcv < P1D.length; lcv++)
			{
				Derivative =  Derivative + " " + P1D[lcv];
			}
			Derivative = Derivative.trim();
			return Derivative;
		}
	}