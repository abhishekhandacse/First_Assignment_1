//..........................................
// Assignment 1
// © Abhishek Handa
// Written by: (Abhishek Handa [40231719])
//.........................................


package Q2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /**
     * This function finds the Voter by Voter Postal code given and prints that.
     */

    static void findVotersByVoterPCode(Voter[] voterBase, String voterPCode) {
        for (int i = 0; i < voterBase.length; i++) {
            if (voterBase[i] == null) continue;
            if (Arrays.equals(voterBase[i].getVoterPcode(), voterPCode.toCharArray()))
                System.out.println(voterBase[i]);
        }
    }

    /**
     * This function finds the voters by age that is less than the age parameter passed to function
     */
    static void findYougerThanByAge(Voter[] voterBase, byte age) {
        for (int i = 0; i < voterBase.length; i++) {
            if (voterBase[i] == null) continue;
            if (voterBase[i].getVoterAge() < age)
                System.out.println(voterBase[i]);
        }
    }

    /**
     * Main method containing the driver code
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String password = "password";
        int option1WrongAttempts = 0;
        final int totalAllowedWrongAttempts = 12;
        final int allowedPasswordWrongAttemps = 3;
        System.out.println("Welcome to Parti Quebecois software application");

        System.out.println("Please enter the maximum number of Voters (maxVoters) neighborhood can contain");
        try {
            int maxVoters = Integer.parseInt(br.readLine());

            Voter[] voterBase = new Voter[maxVoters];
            int voterBaseCount = 0;

            while (true) {
                if (option1WrongAttempts >= totalAllowedWrongAttempts) {
                    System.out.println("Program detected suspicious activities and will terminate immediately");
                    break;
                }
                System.out.println("What do you want to do ?");
                System.out.println("1. Enter new voters (password required)");
                System.out.println("2. Change information of a voter (password required)");
                System.out.println("3. Display all voters by a specific voterPcode");
                System.out.println("4. Display all voters under a certain age");
                System.out.println("5. Quit");

                int selectedOption = Integer.parseInt(br.readLine());

                if (selectedOption == 1) {
                    int i;
                    for (i = 0; i < allowedPasswordWrongAttemps; i++) {
                        System.out.println("Please enter the password");
                        String userEnteredPassword = br.readLine();
                        if (userEnteredPassword.equals(password)) {
                            System.out.println("How many Voters you want to add ?");
                            int numberOfVoters = Integer.parseInt(br.readLine());
                            if ((voterBaseCount + numberOfVoters) > maxVoters) {
                                System.out.println("Due to space constraints, you can only add " + Math.max((maxVoters-voterBaseCount-numberOfVoters),0 ) + " number of voters");
                            }

                            for (int j = 0; j < numberOfVoters; j++) {
                                if (voterBaseCount >= maxVoters) {
                                    System.out.println("Maximum Voters limit reached, cannot enter more voters");
                                    break;
                                }
                                System.out.println("Please enter voterId and hit new line");
                                long voterID = Long.parseLong(br.readLine());
                                System.out.println("Please enter voterName and hit new line");
                                String voterName = br.readLine();
                                System.out.println("Please enter voterAge and hit new line");
                                byte voterAge = Byte.parseByte(br.readLine());
                                System.out.println("Please enter voterEmail and hit new line");
                                String voterEmail = br.readLine();
                                System.out.println("Please enter voterPcode and hit new line");
                                String voterPcode = br.readLine();
                                Voter voter = new Voter(voterID, voterName, voterAge, voterEmail, voterPcode.toCharArray());
                                voterBase[voterBaseCount] = voter;
                                voterBaseCount++;
                            }

                            option1WrongAttempts = 0;
                            break;
                        } else {
                            System.out.println("The password you have entered is not correct, Please try again !!");
                        }
                    }
                    if (i == allowedPasswordWrongAttemps) {
                        option1WrongAttempts += allowedPasswordWrongAttemps;
                    }
                } else if (selectedOption == 2) {
                    int i = 0;
                    boolean hasQuit = false;
                    for (i = 0; i < allowedPasswordWrongAttemps; i++) {

                        System.out.println("Please enter the password");
                        String userEnteredPassword = br.readLine();
                        if (userEnteredPassword.equals(password)) {
                            while (true) {
                                System.out.println("Please enter the voterId of the voter whose data needs to be updated");
                                long userEnteredVoterId = Long.parseLong(br.readLine());
                                int j = 0;
                                for (j = 0; j < maxVoters; j++) {
                                    if (voterBase[j] == null) continue;
                                    long voterId = voterBase[j].getVoterID();
                                    if (userEnteredVoterId == voterId) {
                                        while (true) {
                                            System.out.println("Voter: # " + j);
                                            System.out.println("ID: " + voterId);
                                            System.out.println("Name: " + voterBase[j].getVoterName());
                                            System.out.println("Age: " + voterBase[j].getVoterAge());
                                            System.out.println("Email: " + voterBase[j].getVoterEmail());
                                            System.out.println("Pcode: " + String.valueOf(voterBase[j].getVoterPcode()));
                                            System.out.println("Which attribute you wish to change ?");
                                            System.out.println("1. Name");
                                            System.out.println("2. Age");
                                            System.out.println("3. Email");
                                            System.out.println("4. PCode");
                                            System.out.println("5. Quit");

                                            String response = br.readLine();
                                            if (response.equals("1")) {
                                                System.out.println("Please enter the name");
                                                String userEnteredName = br.readLine();
                                                voterBase[j].setVoterName(userEnteredName);
                                            } else if (response.equals("2")) {
                                                System.out.println("Please enter the age");
                                                byte userEnteredVoterAge = Byte.parseByte(br.readLine());
                                                voterBase[j].setVoterAge(userEnteredVoterAge);
                                            } else if (response.equals("3")) {
                                                System.out.println("Please enter the email");
                                                String userEnteredEmail = br.readLine();
                                                voterBase[j].setVoterEmail(userEnteredEmail);
                                            } else if (response.equals("4")) {
                                                System.out.println("Please enter the PCode");
                                                String userEnteredPcode = br.readLine();
                                                voterBase[j].setVoterPcode(userEnteredPcode.toCharArray());
                                            } else if (response.equals("5")) {
                                                System.out.println("Quiting !!");
                                                hasQuit = true;
                                                break;
                                            } else {
                                                System.out.println("Sorry !! Only numbers between 1 to 5 are allowed");
                                            }
                                        }
                                    }
                                }
                                if (hasQuit == true) {
                                    break;
                                }
                                if (j == maxVoters) {
                                    System.out.println("No Voter with the given Voter Id found, Do you want to enter the Voter Id again ? [yes/no]");
                                }
                                String response = br.readLine();
                                if ("no".equals(response.toLowerCase())) {
                                    break;
                                }
                            }
                        } else {
                            System.out.println("The password you have entered is not correct, Please try again !!");
                        }
                        if (hasQuit == true) {
                            break;
                        }
                    }
                } else if (selectedOption == 3) {
                    System.out.println("Please enter the voterPcode");
                    String userEnteredVoterPCode = br.readLine();
                    findVotersByVoterPCode(voterBase, userEnteredVoterPCode);
                } else if (selectedOption == 4) {
                    System.out.println("Please enter the voter age");
                    byte age = Byte.parseByte(br.readLine());
                    findYougerThanByAge(voterBase, age);
                } else if (selectedOption == 5) {
                    System.out.println("You have selected to end the program !!");
                    break;
                } else {
                    System.out.println("Please select the input from the given options only !!");
                }
            }
        } catch (IOException e) {
            //Since we are using BufferedReader, it may throw the IOException(It may occur due to the file deleted or
            //viruses in the file. Sometimes BufferedReader takes data from a network stream where the reading system
            //can fail at any time. So this type of error can occur in input operation when a BufferedReader is used.)
            System.out.println("There was an IOException while reading the input " + e);
        }catch (NumberFormatException e){

            System.out.println("In Java that occurs when an attempt is made to convert a string with an incorrect format to a numeric value "+e);
        }

        catch (Exception e) {
            //Handling the exception in case any exception occurs above, and we have not handled that exception.
            //So it will get handled in this catch and program will continue to run.
            System.out.println("There was an Exception" + e);
        }
    }
}
