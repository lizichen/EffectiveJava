package JavaBasics;

/**
 * Java Lambda Syntax:
 *  parameter -> expresssion body
 *
 *  1. No need to declare the type of a parameter.
 *  2. No need to declare a single parameter in parenthesis, except multiple parameters.
 *  3. No need to use curly braces in expression body if the body contains a single statement.
 */
public class Java8LambdaTest {

    public static void main(String args[]){
        Java8LambdaTest tester = new Java8LambdaTest();

        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;

        MathOperation multiplication = (int a, int b) -> { return a * b; }; // or a * b directly.
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + multiplication.operation(10, 5));
        System.out.println("10 / 5 = " + division.operation(10, 5));


        GreetingService greetService1 = message -> System.out.println("Hello " + message);
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
        NamePrinter multiValueObj = (msg1, msg2) -> System.out.println("First Name: "+ msg1 + " Last Name:" + msg2);

        greetService1.sayMessage("Hello");
        greetService2.sayMessage("World");
        multiValueObj.print("Lizi", "Chen");
    }

    interface NamePrinter{
        void print(String s1, String s2);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
