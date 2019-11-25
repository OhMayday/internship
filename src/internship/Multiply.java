package internship;

public class Multiply {

	public static String mult(String value1, String value2) {
		
		
		String mult = "";
		String[] V1 = value1.split("\\s+");
		String[] V1M = new String[V1.length];
		String[] V2 = value2.split("\\s+");
		String[] V2M = new String[V2.length];
		
		
		
		if ((value1.contains("x")) && (value2.contains("x") != true))
		{
			
			for (int lcv = 0; lcv < V1.length; lcv++)
			{
				if (V1[lcv].contains("x"))
				{
					int ix = V1[lcv].indexOf('x');
					String End = V1[lcv].substring(ix, V1[lcv].length());
					String Coeff = V1[lcv].substring(0, ix);
					V1M[lcv] = (Integer.valueOf(Coeff) * Integer.valueOf(value2)) + End;
				}
				else if (V1[lcv].matches("[+-]"))
				{
					V1M[lcv] = V1[lcv];
				}
				else
				{
					V1M[lcv] = Integer.valueOf(V1[lcv]) * Integer.valueOf(value2) + "";
				}
				mult =  mult + " " + V1M[lcv];
			}
			mult = mult.trim();
			
		}
		else if ((value2.contains("x")) && (value1.contains("x") != true))
		{

			
			for (int lcv = 0; lcv < V2.length; lcv++)
			{
				if (V2[lcv].contains("x"))
				{
					int ix = V2[lcv].indexOf('x');
					String End = V2[lcv].substring(ix, V2[lcv].length());
					String Coeff = V2[lcv].substring(0, ix);
					V2M[lcv] = (Integer.valueOf(Coeff) * Integer.valueOf(value1)) + End;
				}
				else if (V2[lcv].matches("[+-]"))
				{
					V2M[lcv] = V2[lcv];
				}
				else
				{
					V2M[lcv] = Integer.valueOf(V2[lcv]) * Integer.valueOf(value1) + "";
				}
				mult =  mult + " " + V2M[lcv];
			}
			mult = mult.trim();
			
		}
		else if ((value2.contains("x")) && (value1.contains("x")))
		{
			for (int lcv = 0; lcv < V1.length; lcv++)
			{
				if (V1[lcv].matches("[-+]"))
				{
					
				}
				for (int lcv2 = 0; lcv2 < V2.length; lcv2++)
				{
					
				}
			}
			int[] v1 = parse(value1);
			int[] v2 = parse(value2);
			
		}
		else
		{
			int v1 = Integer.valueOf(value1);
			int v2 = Integer.valueOf(value2);
			mult = String.valueOf(Math.multiplyExact(v1, v2));
		}

		
		return mult;
		
			
		
	}
	public static int[] parse(String value) // 0 is coeff 1 is power
	{
	    int pos = value.indexOf("x^");
	    String coeffStr = value.substring(0, pos);
	    int coeff = Integer.parseInt(coeffStr);
	    String powerStr = value.substring(pos + 2);
	    int power = Integer.parseInt(powerStr);
	    int[] ret = new int[2];
	    ret[0] = coeff;
	    ret[1] = power;
	    return ret;
	}
	

}
