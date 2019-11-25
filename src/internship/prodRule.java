package internship;

public class prodRule {
	
	public static String derive(String value1, String value2)
	{
		String Derivative = "";
		String d1x = SingleDerivative.Derive(value1);
		String d2x = SingleDerivative.Derive(value2);
		String t1 = "(" + d1x + ")";
		
		
		
		return Derivative;
	}
}
