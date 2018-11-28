package JavaBasics;

import java.util.*;

public class ComparableAndComparatorDemo {

    public static void demo1(){
        Student s1 = new Student("Alice", 14, 3.5);
        Student s2 = new Student("Borac", 13, 3.2);
        Student s3 = new Student("Cathy", 12, 4.0);
        Student s4 = new Student("Danni", 11, 3.7);
        Student s5 = new Student("Danni", 10, 2.7);
        List<Student> studentList = new ArrayList<>();

        studentList.add(s5);
        studentList.add(s4);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s1);

        System.out.println("Default sorting");
        Collections.sort(studentList);
        for(Student s : studentList){
            System.out.println(s);
        }

        System.out.println("Use StudentAgeComparator");
        Collections.sort(studentList, new StudentAgeComparator());
        for(Student s : studentList){
            System.out.println(s);
        }

        System.out.println("Use StudentGPAComparator");
        Collections.sort(studentList, new StudentGPAComparator());
        for(Student s : studentList){
            System.out.println(s);
        }

        System.out.println("Searching s1 without Comparactor:");
        int searchIdx1 = Collections.binarySearch(studentList, s1);
        System.out.println(searchIdx1);

        System.out.println("Searching s1 with StudentAgeComparator:");
        int searchIdx2 = Collections.binarySearch(studentList, s1, new StudentAgeComparator());
        System.out.println(searchIdx2);
    }

    public static void main(String[] args) {
        demo1();
    }
}

class Student implements Comparable<Student> {
    String name;
    int age;
    double gpa;

    public Student(String n, int a){
        this.name = n;
        this.age = a;
    }

    public Student(String n, int a, double gpa){
        this.name = n;
        this.age = a;
        this.gpa = gpa;
    }

    @Override
    public String toString(){
        return "Name: "+this.name + "\tAge: " + this.age + "\tGPA: " + this.gpa;
    }

    @Override
    public int compareTo(Student another) {
        int i = name.compareTo(another.name);
        if(i == 0) {
            return age - another.age;
        } else {
            return i;
        }
    }
}

class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student one, Student another) {
        return one.age - another.age;
    }
}

class StudentGPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2){
        return s1.gpa > s2.gpa ? 1 : -1;   // 1: first > second
                                           // 0: same, no move
                                           // -1: second > first
    }
}