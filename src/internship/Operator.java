package internship;
import java.util.*;



public class Operator extends Expression {

    String op;
    int precedence;
    Expression left;
    Expression right;

    public Operator(String op)
    {
        this.op = op;
        if(op.equals("^"))
            this.precedence = 15;
        else if(op.equals("*") || op.equals("/"))
            this.precedence = 10;
        else if(op.equals("+") || op.equals("-"))
            this.precedence = 5;
        else
            this.precedence = 0;
    }

    public String toString() 
    {
        return this.op;
    }

    public int getPrecedence() 
    {
        return this.precedence;
    }

    public void getOperands(ArrayList<Expression> tokens)
    {
        Expression exp = tokens.get(0);
        tokens.remove(0);
        if((exp instanceof Operator))
        {
            Operator op = (Operator)exp;
            op.getOperands(tokens);
        }
        this.right = exp;

        exp = tokens.get(0);
        tokens.remove(0);
        if((exp instanceof Operator))
        {
            Operator op = (Operator)exp;
            op.getOperands(tokens);
        }
        this.left = exp;
    }

    public String getEquation()
    {
        return this.left.getEquation() + " " +
               this.toString() + " " +
               this.right.getEquation();
    }

    public static boolean isOperator(String token)
    {
        return token.equals("^") || 
               token.equals("+") || 
               token.equals("-") ||
               token.equals("*") ||
               token.equals("/");
    }
}
