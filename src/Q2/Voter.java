//..........................................
// Assignment 1
// © Abhishek Handa
// Written by: (Abhishek Handa [40231719])
//.........................................


package Q2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Voter class with the attributes of Voter defined along with Constructors, Equals, HashCode and toString method
 */
public class Voter {
    long voterID;
    String voterName;
    byte voterAge;
    String voterEmail;
    char[] voterPcode;

    static int numberOfCreatedVoters=0;

    /**
     * This function returns the Number of Created Voters
     */
    static int findNumberofCreatedVoters(){
        return numberOfCreatedVoters;
    }

    public Voter() {
    }
    public Voter(long voterID, String voterName, byte voterAge, String voterEmail, char[] voterPcode) {
        this.voterID = voterID;
        this.voterName = voterName;
        this.voterAge = voterAge;
        this.voterEmail = voterEmail;
        this.voterPcode = voterPcode;
        numberOfCreatedVoters++;
    }

    /**
     * Getter for numberOfCreatedVoters parameter
     */
    public static int getNumberOfCreatedVoters() {
        return numberOfCreatedVoters;
    }

    /**
     * Setter for numberOfCreatedVoters parameter
     */
    public static void setNumberOfCreatedVoters(int numberOfCreatedVoters) {
        Voter.numberOfCreatedVoters = numberOfCreatedVoters;
    }

    /**
     * Getter for voterID parameter
     */
    public long getVoterID() {
        return voterID;
    }

    /**
     * Getter for voterName parameter
     */
    public String getVoterName() {
        return voterName;
    }

    /**
     * Setter for voterName parameter
     */
    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    /**
     * Getter for voterAge parameter
     */
    public byte getVoterAge() {
        return voterAge;
    }

    /**
     * Setter for voterAge parameter
     */
    public void setVoterAge(byte voterAge) {
        this.voterAge = voterAge;
    }

    /**
     * Getter for voterEmail parameter
     */
    public String getVoterEmail() {
        return voterEmail;
    }

    /**
     * Setter for voterEmail parameter
     */
    public void setVoterEmail(String voterEmail) {
        this.voterEmail = voterEmail;
    }

    /**
     *
     * Getter for voterPCode
     */
    public char[] getVoterPcode() {
        return voterPcode;
    }

    /**
     *
     * Setter for voterPCode
     */
    public void setVoterPcode(char[] voterPcode) {
        this.voterPcode = voterPcode;
    }

    /**
     * Overriding the toString() method for printing the parameters easily
     */
    @Override
    public String toString() {
        return "Voter{" +
                "voterID=" + voterID +
                ", voterName='" + voterName + '\'' +
                ", voterAge=" + voterAge +
                ", voterEmail='" + voterEmail + '\'' +
                ", voterPcode=" + Arrays.toString(voterPcode) +
                '}';
    }

    /**
     *Overriding the equals method for object equality comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return voterID == voter.voterID && Arrays.equals(voterPcode, voter.voterPcode);
    }

    /**
     * Overriding hashCode() method since equals is also overridden
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(voterID);
        result = 31 * result + Arrays.hashCode(voterPcode);
        return result;
    }
}
