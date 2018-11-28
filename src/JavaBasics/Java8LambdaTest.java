package JavaBasics;

import util.Printer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        lambda_demo1();
        lambda_sortDemo();
    }

    public static void lambda_sortDemo(){
        List<Student> studentList = new LinkedList<>();
        Student s1 = new Student("1Anddy", 25, 3.2);
        Student s2 = new Student("2Bobby", 24, 3.3);
        Student s3 = new Student("3Cathy", 23, 3.4);

        Student s4 = new Student("4Davis", 22, 3.5);
        Student s5 = new Student("5Effie", 22, 3.6);
        Student s6 = new Student("6Fredy",22, 3.6);
        Student s7 = new Student("7Gabby", 22, 3.7);

        Student s8 = new Student("8Helen", 21, 3.8);

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
        studentList.add(s7);
        studentList.add(s8);

        System.out.println("Increasing order in age, Decreasing order in gpa:");
        Collections.sort(studentList, (a, b) -> a.age == b.age ? (a.gpa > b.gpa ? 1 : 0) : (a.age - b.age > 0 ? 1 : -1));
        Printer.printList(studentList);
    }

    public static void lambda_demo1(){
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
