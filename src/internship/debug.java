package internship;

public class debug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value = "(5x^2 - 8x + 7 - 3x^4 + 6x^10)^3";
		
		
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

		System.out.println(Chain);
	}

}
