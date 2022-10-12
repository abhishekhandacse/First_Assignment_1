//..........................................
// Assignment 1
// © Abhishek Handa
// Written by: (Abhishek Handa [40231719])
//.........................................


package Q1;

import java.util.*;

public class Q2Part1 {

    static boolean isVowel(Character c){
        if(c=='a' ||c=='e' ||c=='i' ||c=='o' ||c=='u' ||c=='A' ||c=='E' ||c=='I' ||c=='O' ||c=='U'){
            return true;
        }
        return false;
    }
    static boolean isNumber(Character c){
        if(c=='0' ||c=='1' ||c=='2' ||c=='3' ||c=='4' ||c=='5' ||c=='6' ||c=='7' ||c=='8' || c=='9'){
            return true;
        }
        return false;
    }
    static String arrange(String str){
        HashMap<Character,Integer> hm=new HashMap<>();

        for(int i=0;i<str.length();i++){
            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
        }
        String consonents="";
        String repeatingConsonents="";
        String numbers="";
        String vowels="";

        for(Map.Entry<Character,Integer> iter:hm.entrySet()){
            Character c=iter.getKey();
            int val=iter.getValue();

            if(isVowel(c)){
                vowels=vowels+c;
            }else if(isNumber(c)){
                numbers=numbers+c;
            }else{
                if(val==1){
                    consonents=consonents+c;
                }else{
                    repeatingConsonents=repeatingConsonents+c;
                }
            }
        }
        char[] consonentsCharArray=consonents.toCharArray();
        Arrays.sort(consonentsCharArray);
        char[] vowelsCharArray=vowels.toCharArray();
        Arrays.sort(vowelsCharArray);
        return new String(consonentsCharArray)+repeatingConsonents+numbers+new String(vowelsCharArray);
    }

    public static void main(String[] args) {
        String str="assignment1";
        String ans=arrange(str);
        System.out.print(ans);
    }
}
/*
1)
    Pseudocode
    Initialize HashMap

    FOR i-> 0 to str.length()-1
        hm.put(Character at pos i, frequency of the character)
    END FOR

    Initialize string consonants, repeatingConsonants, numbers and vowels

    For i-> HashMap start to HashMap end
        Character:= HasMap character at i
        Value:= Frequency of character at i

        IF Character is Vowel
            Append to Vowel String
        ELSE IF Character is Number
            Append to Number String
        ELSE
            IF Value is 1
                Append to Consonant String
            ELSE
                Append to RepeatingConsonant String
            END IF

        END IF

    END FOR

    consonant:=sort(consonant)
    vowel:=sort(vowel)

    PRINT consonant, repeatingConsonant, Number, Vowel
2) Time Complexity-: O(NlogN)
3) Space Complexity -: O(N)
*/