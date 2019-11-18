package internship;
import java.util.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ConsoleTest {

    public void printExpression(Expression exp)
    {
        System.out.print(exp);
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter in the equation for which you want the derivative (Make sure there are spaces between operators!)");
		String P = scan.nextLine();
		System.out.println(P);
		
        ArrayList<Expression> output = new ArrayList<Expression>();
        Stack ops = new Stack();
        String[] tokens = P.split(" ");
        int i = 0;
        while(i < tokens.length)
        {
            String token = tokens[i];
            ++i;
            if(Literal.isLiteral(token))
            {
                output.add(new Literal(token));
            }
            else if(Operator.isOperator(token))
            {
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
        }
        while(!ops.empty())
        {
            Operator op = (Operator) ops.pop();
            output.add(op);
        }
        Collections.reverse(output);

        /*
        System.out.println("Outputs:");
        for(Object obj : output) {
            Expression exp = (Expression)obj;
            System.out.println("  "+exp.toString());
        }
        */

        Expression exp = output.get(0);
        output.remove(0);
        if(!(exp instanceof Operator))
            throw new RuntimeException("Found unexpected Expression type "+exp.toString());
        Operator op = (Operator)exp;
        op.getOperands(output);

        if(!output.isEmpty())
        {
            System.out.println("ERROR: Unbalanced equation");
            return;
        }

        System.out.println(op.getEquation());
    }
}
