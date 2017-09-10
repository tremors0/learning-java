package tutorial.lambdaExpression._02;

/**
 * Lambda vyraz s parametry
 */
public class LambdaAdder {

    public static void main(String[] args) {
        // Nemusi se specifikovat datovy typ parametru
        // Je zjisten z rozhrani
        AdderLambdaInterface add = (a, b) -> a + b;

        System.out.println(add.add(5.0, 5.5));
    }
}

/**
 * AdderLambdaInterface
 */
interface AdderLambdaInterface {
    double add(double firstNumber, double secondNumber);
}