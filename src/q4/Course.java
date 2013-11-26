package q4;

import java.util.ArrayList;
/**
 * The course class, allows you to create a course  of up to 5 students 
 * and provides information on the course and the people in it.
 * 
 * @author Marc
 * @version 1.0
 *
 */
public class Course {
    /** The maximum number of people that can be in a course. */
    private static final int MAXSTUDENTS = 5;
    /** The Name of the course. */
    private String name;
    /** The students in the class. */
    private ArrayList<Student> course = new ArrayList<Student>();
    
    /**
     * The constructor for the course object.
     * 
     * @param cName the name of the course.
     */
    public Course(String cName) {
        name = cName;
    }
    /** Adds a student to the course. 
     * @param stu a student 
     */
    public void addStudent(Student stu) {
        if (course.size() < MAXSTUDENTS) {
            course.add(stu);
        } else {
            throw new IllegalArgumentException();
        }
        
    }
    /**
     * Prints out all of the students in the course.
     */
    public void roll() {
        System.out.println(" the students in "
                + name + " are:");
        for (Student stu : course) {
            System.out.println(stu);
            System.out.println("\n");
        }
    }
    /**
     * computes the average grade in a course.
     * @return the average of all the students in the course
     */
    public double average() {
        double total = 0;
        for (Student stu : course) {
            total += stu.average();
        }
        return total / course.size();
    }
}
