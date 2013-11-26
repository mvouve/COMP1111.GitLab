package q3;

/**
 * Represents a college student.
 * @author Lewis
 * @author Loftus
 * @author Marc Vouve
 * @version 2
 */
public class Student {
    /** the maximum someone may achieve on a test. */
    static final int MAX_SCORE = 100;
    /** Accommodating for checkstyle. */
    static final int THREE = 3;
    /** First name of this student. */
    private String firstName;
    /** Last name of this student. */
    private String lastName;
    /** Home address of this student. */
    private Address homeAddress;
    /** School address of this student.  Can be shared by other students */
    private Address schoolAddress;
    /** First test score of student. */
    private double test1;
    /** First test score of student. */
    private double test2;
    /** First test score of student. */
    private double test3;




    /**
     * Constructor: Sets up this student with the specified values.
     * @param first The first name of the student
     * @param last The last name of the student
     * @param home The home address of the student
     * @param school The school address of the student
     */
    public Student(String first, String last, Address home, Address school) {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
    }
    /** empty constructor for student object. */
    public Student() {
    }
    /** set the sore on a test.
     * @param testNo specifies which test to modify
     * @param testScore specifies the score on the test */

    public void setTestScore(int testNo, double testScore) {
        if (testScore > MAX_SCORE || testScore < 0) {
            throw new IllegalArgumentException("Invalid test score");
        }
        switch(testNo) {
        case 1:
            test1 = testScore;
            break;
        case 2:
            test2 = testScore;
            break;
        case THREE:
            test3 = testScore;
            break;
        default:
            throw new IllegalArgumentException("Invalid test number");
        }
    }
    /**
     * Returns the result of a test.
     * @param testNo the test number
     * @return the result on that test
     */
    public double getTestScore(int testNo) {
        switch(testNo) {
        case 1:
            return test1;
        case 2:
            return test2;
        case THREE:
            return test3;
        default:
            throw new IllegalArgumentException();
        }
    }
    /**
     * get the average score on all the tests.
     * @return the average of all 3 tests
     */
    public double average() {
        return (test1 + test2 + test3) / THREE;
    }

    /**
     * Returns a string description of this Student object.
     * @return formatted name and addresses of student
     */
    public String toString() {
        String result;

        result = firstName + " " + lastName + "\n";
        result += "Home Address:\n" + homeAddress + "\n";
        result += "School Address:\n" + schoolAddress + "\n";
        result += "Test One:\n" + test1 + "\n";
        result += "Test Two:\n" + test2 + "\n";
        result += "Test Three:\n" + test3 + "\n";
        result += "\nAverage Test Score:\n" + average();

        return result;
    }
}
