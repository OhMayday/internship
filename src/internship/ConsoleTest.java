package internship;
import java.util.Scanner;

public class ConsoleTest {

    public void printExpression(Expression exp)
    {
        System.out.print(exp);
    }

    public static void main2(String []args) {
        System.out.println("Hello World");
        ConsoleTest console = new ConsoleTest();

        Literal l5 = new Literal(5);
        Literal l3 = new Literal(3);
        Operator plus = new Operator("+");

        console.printExpression(l5);
        console.printExpression(plus);
        console.printExpression(l3);

        System.out.println("");
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter in the equation for which you want the derivative (Make sure there are spaces between operators!)");
		String P = scan.nextLine();
		System.out.println(P);
		
        String[] tokens = P.split(" ");
        for(int i = 0; i < tokens.length; ++i)
        {
		    System.out.println(tokens[i]);
            Expression e;
            if(Literal.isLiteral(tokens[i]))
                e = new Literal(tokens[i]);
		        //System.out.println("  is literal");
        }
	}

}
