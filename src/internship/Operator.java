package internship;
public class Operator extends Expression {

    String op;

    public Operator(String op)
    {
        this.op = op;
    }

    public String toString() 
    {
        return this.op;
    }
}
