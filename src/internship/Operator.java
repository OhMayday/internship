package internship;



public class Operator extends Expression {

    String op;
    int precedence;

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
}
