public class Literal extends Expression {

    Integer value;

    public Literal(int value)
    {
        this.value = value;
    }

    public String toString() 
    {
        return this.value.toString();
    }
}
