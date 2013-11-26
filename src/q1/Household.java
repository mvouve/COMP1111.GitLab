package q1;

import java.text.NumberFormat;


/**
 * <p>This class holds information on households, it can check various things
 * including information on the households ID, Income and if they are below
 * the low income line.</p>
 *
 * @author Marc Vouve
 * @version 1.0
 */
public class Household {

    /** This is to deal with checkstyle not liking cases to be easy. */
    private static final int THREE = 3;
    /** This is to deal with checkstyle not liking cases to be easy. */
    private static final int FOUR = 4;
    /** This is to deal with checkstyle not liking cases to be easy. */
    private static final int FIVE = 5;
    /** This is to deal with checkstyle not liking cases to be easy. */
    private static final int SIX = 6;
    /** This is to deal with checkstyle not liking cases to be easy. */
    private static final int SEVEN = 7;
    
    /** The Canadian low income cut off for a household of 1.*/
    private static final int LOWINCOME1 = 22229;
    /** The Canadian low income cut off for a household of 2.*/
    private static final int LOWINCOME2 = 27674;
    /** The Canadian low income cut off for a household of 3.*/
    private static final int LOWINCOME3 = 34022;
    /** The Canadian low income cut off for a household of 4.*/
    private static final int LOWINCOME4 = 41307;
    /** The Canadian low income cut off for a household of 5.*/
    private static final int LOWINCOME5 = 46850;
    /** The Canadian low income cut off for a household of 6.*/
    private static final int LOWINCOME6 = 52838;
    /** The Canadian low income cut off for a household of 7.*/
    private static final int LOWINCOME7 = 58827;
    /** The Canadian low income modifier per person for 
     * households of more then 7.*/
    private static final int LOWINCOMEMOD = 5989;
    
    /** the identification number for the household. */
    private int id;
    /** The number of people living in the household. */
    private int members;
    /** The total household income of the given household. */
    private double income;
    
    /** The default constructor for creating a new household.
     * @param hhId the id of the household
     * @param hhIncome the income of the household
     * @param hhMembers the number of people living in the household
     *  */
    public Household(int hhId, double hhIncome, int hhMembers) {
        id = hhId;
        members = hhMembers;
        income = hhIncome;
    }
    
    /** creates a formated string with general
     *  information about the household.
     *  @return a string about the household its id and members */
    
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();

        return id + "\t" + money.format(income) + "\t" + members;
    }
    
    /**  Returns the income of a given household.
     * @return  householdIncome */
    public double getIncome() {
        return income;
    }
    
    /** returns the ID of the household. *
     @return household ID*/
    public int getId() {
        return id;
    }
    /** Checks if income is below the low income cut off.
     * @return true if below cutoff, false if not*/
    public boolean lowIncomeCheck() {
        switch(members) {
        case 1:
            return (income < LOWINCOME1);
        case 2:
            return (income < LOWINCOME2);
        case THREE:
            return (income < LOWINCOME3);
        case FOUR:
            return (income < LOWINCOME4);
        case FIVE:
            return (income < LOWINCOME5);
        case SIX:
            return (income < LOWINCOME6);
        case SEVEN:
            return (income < LOWINCOME7);
        default:
            return (income < (LOWINCOME7 + (LOWINCOMEMOD * (members - SEVEN))));

        }
    }

};
