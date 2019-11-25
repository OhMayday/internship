package internship;



public class Literal extends Expression {

    Integer value;

    public Literal(int value)
    {
        this.value = value;
    }

    public Literal(String token)
    {
        this.value = Integer.parseInt(token);
    }

    public String toString() 
    {
        return this.value.toString();
    }

    public String getEquation()
    {
        return this.toString();
    }

    public static boolean isLiteral(String term) 
    { 
        return term.matches("^[0-9]+$"); 
    } 
}
