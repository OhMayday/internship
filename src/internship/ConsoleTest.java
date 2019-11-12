package internship;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

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

	public static void main3(String[] args) {
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

    public static boolean isLiteral(String token)
    {
        return Literal.isLiteral(token);
    }

    public static boolean isOp(String token)
    {
        return token.equals("^") || 
               token.equals("+") || 
               token.equals("-") ||
               token.equals("*") ||
               token.equals("/");
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter in the equation for which you want the derivative (Make sure there are spaces between operators!)");
		String P = scan.nextLine();
		System.out.println(P);
		
        LinkedList output = new LinkedList();
        Stack ops = new Stack();
        String[] tokens = P.split(" ");
        int i = 0;
        while(i < tokens.length)
        {
            String token = tokens[i];
            ++i;
            System.out.print("Token = ");
            if(isLiteral(token))
            {
                System.out.println("  Literal");
                output.add(new Literal(token));
            }
            else if(isOp(token))
            {
                System.out.println("  Op");

                Operator curr = new Operator(token);
                while(!ops.empty())
                {
                    Expression exp = (Expression) ops.peek();
                    if(!(exp instanceof Operator))
                        throw new RuntimeException("Found unexpected Expression type "+exp.toString());

                    Operator top = (Operator)exp;
                    if(top.getPrecedence() > curr.getPrecedence() /* && top != left paren*/)
                    {
                        output.add(top);
                        ops.pop();
                        continue;
                    }
                    break;
                }
                ops.push(curr);
            }
            else
                System.out.println("  Other");
        }
        while(!ops.empty())
        {
            Operator op = (Operator) ops.pop();
            output.add(op);
        }

        
        System.out.println("Outputs:");
        for(Object obj : output) {
            Expression exp = (Expression)obj;
            System.out.println("  "+exp.toString());
        }
        System.out.println("Operators:");
        while(!ops.empty()) {
            Expression exp = (Expression)ops.pop();
            System.out.println("  "+exp.toString());
        }
    }
}
