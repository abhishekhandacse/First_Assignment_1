//..........................................
// Assignment 1
// © Abhishek Handa
// Written by: (Abhishek Handa [40231719])
//.........................................


package Q1;

// 1)
public class Q3Part1 {

    static void printTetradic(int[] arr,int number){
        int first=0,second=0,diff=0,consectiveDiff=Integer.MIN_VALUE,consectiveFirst=0,consectiveSecond=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
               if(Math.abs(arr[i]-arr[j])==number){
                  if(diff<(j-i)){
                      diff=(j-i);
                      first=arr[i];
                      second=arr[j];
                  }
               }
               if(consectiveDiff<Math.abs(arr[i]-arr[i+1])){
                   consectiveDiff=Math.abs(arr[i]-arr[i+1]);
                   consectiveFirst=arr[i];
                   consectiveSecond=arr[i+1];
               }
            }

        }
        System.out.println("Two Farthest tetraheadic numbers with difference equal to " + number +" are "+first+" & "+ second+ " which have " + (diff-1)+" elements between them");
        System.out.println("Two consective Tetraheadic numbers with maximum difference are " + consectiveFirst +" "+consectiveSecond);
    }

    public static void main(String[] args) {
        int[] arr=new int[]{11,111,88,101,181,808,1,818,0};
        int number=10;
        printTetradic(arr,number);
    }
}
/*
// Pseudocode
1)
  INPUT arr and number
  Intitialize first=0,second=0,diff=0,consectiveDiff=Integer.MIN_VALUE,consectiveFirst=0,consectiveSecond=0;
    FOR i=0 to i= arr.length-2
        FOR j=i+1 to j=arr.length-1
            IF(Math.abs(arr[i]-arr[j]) is number){
                  IF(diff less than(j-i)){
                      diff:=(j-i);
                      first:=arr[i];
                      second:=arr[j];
                  }
                  END IF
               }
            END IF
            IF(consectiveDiff less than Math.abs(arr[i]-arr[i+1])){
                   consectiveDiff:=Math.abs(arr[i]-arr[i+1]);
                   consectiveFirst:=arr[i];
                   consectiveSecond:=arr[i+1];
            }
            END IF
        END FOR
    END FOR

    PRINT("Two Farthest tetraheadic numbers with difference equal to " + number +" are "+first+" & "+ second+ " which have " + (diff-1)+" elements between them");
    PRINT("Two consective Tetraheadic numbers with maximum difference are " + consectiveFirst +" "+consectiveSecond);

ii)
    Motive Behind design-: To Solve the problem in a brute force manner so that we can have a pseudocode initially
    which we can optimize later on if asked.
    Talking about the Algorithm, We are just trying to maximise the difference between the two elements using nested
    loops and trying to capture the farthest indexes
    For Successive tetradic numbers, we are just iterating the array and trying to maximise the difference between
    adjacent elements.
    We are capturing the elements which gave us the maximum difference in variable consecutiveFirst and consecutiveSecond
    respectively.

iii)
     Time Complexity-: O(N^2)
     Since we are iterating in a nested loop, so it will cost us TC-: O(N^2)
     Other operations are constant time only
     so taking the maximum as the worst case time complexity will be
     O(N^2)

iV)
    Since we are not using any extra space so the size of space stack growth will be
    constant
    i:e O(1)
* */