import java.util.ArrayList;
import java.util.Scanner;

abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void displayDetails();
}

class Student extends Person {
    int rollNumber;

    public Student(String name, int age, int rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }

    @Override
    public void displayDetails() {
        System.out.println("----- Student Details -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Roll Number: " + rollNumber);
    }
}

class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayDetails() {
        System.out.println("----- Teacher Details -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subject: " + subject);
    }
}

public class StudentInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Display All");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option;
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input. Try again.");
                scanner.next(); // clear invalid input
                continue;
            }

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Student Name: ");
                    String sName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int sAge = scanner.nextInt();
                    System.out.print("Enter Roll Number: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    people.add(new Student(sName, sAge, roll));
                    System.out.println("Student added.");
                }
                case 2 -> {
                    System.out.print("Enter Teacher Name: ");
                    String tName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int tAge = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Subject: ");
                    String subject = scanner.nextLine();
                    people.add(new Teacher(tName, tAge, subject));
                    System.out.println("Teacher added.");
                }
                case 3 -> {
                    if (people.isEmpty()) {
                        System.out.println("No entries yet.");
                    } else {
                        for (Person p : people) {
                            p.displayDetails();
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    running = false;
                    scanner.close();
                }
                default -> System.out.println("Invalid option. Please choose between 1-4.");
            }
        }
    }
}
