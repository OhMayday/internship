package internship;

public class chainRule extends Rules{

	String Derive;
	
	public static String derive(String value)
	{
		int coeff = 0;
		int beginParan = value.indexOf("(");
		int endParan = value.lastIndexOf(")");
		int car = value.lastIndexOf('^');
		if (value.charAt(0) == '(')
		{
			coeff = 1;
		}
		else
		{
			coeff = Integer.valueOf(value.substring(0, beginParan));
		}
		int pow = Integer.valueOf(value.substring(car + 1, value.length()));
		coeff = coeff * pow; // multiply coefficient by power dropped

		String x1 = value.substring(beginParan+1, endParan);
		String d1x = SingleDerivative.Derive(x1);
		String strCoeff = String.valueOf(coeff);
		
		String fullCoeff = Multiply.mult(strCoeff, d1x);
		
		String Chain = "(" + fullCoeff + ")*("+x1+")^"+(pow-1);
		
		return Chain;
	}
	
}
