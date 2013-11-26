package q4;

import java.util.ArrayList;
import java.util.Random;

/**
 * <p>This class builds addresses, students and a course.
 * It is intended to test the course class</p>
 *
 * @author Marc Vouve
 * @version 1.0
 */
public class TestCourse {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        final int maxGrade = 100;
        final int tests = 3;
        Random rand = new Random();
        Address bcit = new Address("3700 Willingdon Ave.", 
                "Burnaby", "British Columbia", "V5G 3H2");
        Address bcitDorm = new Address("3700 Willingdon Ave.", 
                "Burnaby", "British Columbia", "V5G 3H2");
        ArrayList<Student> people = new ArrayList<Student>();
        people.add(new Student("Abe", "Kramer", bcitDorm, bcit));
        people.add(new Student("Dave", "Jones", bcitDorm, bcit));
        people.add(new Student("James", "Camron", bcitDorm, bcit));
        people.add(new Student("Sally", "Pherson", bcitDorm, bcit));
        people.add(new Student("Frank", "Smith", bcitDorm, bcit));
        people.add(new Student("UhOh", "Breaker", bcitDorm, bcit));
        Course comp1510 = new Course("COMP 1510");
        for (Student stu : people) {
            try {
                comp1510.addStudent(stu);
            } catch (IllegalArgumentException e) {
                System.out.println("Too many students! The "
                        + "following has not been added to the list:\n" + stu 
                        + "\n");
            }
        }
        System.out.println("*********************");
        System.out.println("Initial Values:");
        comp1510.roll();
        System.out.println("*******End of intital values*********\n\n");
        for (Student stu : people) {
            for (int i = 1; i <= tests; i++) {
                stu.setTestScore(i, rand.nextInt(maxGrade + 1));
            }
        }
        comp1510.roll();
        System.out.println("The class average is:");
        System.out.println("-----------");
        System.out.println(comp1510.average() + "%");
        System.out.println("Question four was called and ran sucessfully.");
    }

};
