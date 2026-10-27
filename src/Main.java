public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator(new AddStrategy());

        System.out.println("Addition: " + calculator.calculate(8, 7));

        calculator.setStrategy(new SubtractStrategy());
        System.out.println("Subtraction: " + calculator.calculate(8, 7));

        calculator.setStrategy(new MultiplyStrategy());
        System.out.println("Multiplication: " + calculator.calculate(8, 7));
    }
}