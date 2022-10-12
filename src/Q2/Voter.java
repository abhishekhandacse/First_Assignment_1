//..........................................
// Assignment 1
// © Abhishek Handa
// Written by: (Abhishek Handa [40231719])
//.........................................


package Q2;

import java.util.Arrays;
import java.util.Objects;

public class Voter {
    long voterID;
    String voterName;
    byte voterAge;
    String voterEmail;
    char[] voterPcode;

    static int numberOfCreatedVoters=0;

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

    public static int getNumberOfCreatedVoters() {
        return numberOfCreatedVoters;
    }

    public static void setNumberOfCreatedVoters(int numberOfCreatedVoters) {
        Voter.numberOfCreatedVoters = numberOfCreatedVoters;
    }

    public long getVoterID() {
        return voterID;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public byte getVoterAge() {
        return voterAge;
    }

    public void setVoterAge(byte voterAge) {
        this.voterAge = voterAge;
    }

    public String getVoterEmail() {
        return voterEmail;
    }

    public void setVoterEmail(String voterEmail) {
        this.voterEmail = voterEmail;
    }

    public char[] getVoterPcode() {
        return voterPcode;
    }

    public void setVoterPcode(char[] voterPcode) {
        this.voterPcode = voterPcode;
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return voterID == voter.voterID && Arrays.equals(voterPcode, voter.voterPcode);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(voterID);
        result = 31 * result + Arrays.hashCode(voterPcode);
        return result;
    }
}
