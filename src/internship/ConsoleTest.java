public class ConsoleTest {

    public void printExpression(Expression exp)
    {
        System.out.print(exp);
    }

    public static void main(String []args) {
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
}
