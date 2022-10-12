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

ii)

iii) Time Complexity-: O(N^2)
     Since we are suing a nested loop so it will cost us TC-: O(N^2)
     Other operations are constant time only
     so taking the maximum as the worst case time complexity will be
     O(N^2)

iV) Since we are not using any extra space so the size of space stack growth will be
    constant
    i:e O(1)
* */