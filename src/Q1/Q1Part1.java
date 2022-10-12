//..........................................
// Assignment 1
// © Abhishek Handa
// Written by: (Abhishek Handa [40231719])
//.........................................

package Q1;

public class Q1Part1 {
    static int[] swap(int[] arr,int m){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==m){
                int temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{5,4,6,9,6,3,6};
        int m=6;

        swap(arr,m);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

/*
Pseudocode

a)

1) arr=INPUT('Enter the arr') , m=INPUT('Enter the m number')
2) FOR i=0 TO arr.length-1
        IF(arr[i] is equal to m){
            temp:=arr[i+1]
            arr[i+1]:=arr[i]
            arr[i]:=temp
            }
        ENDIF
        INCREMENT i
   ENDFOR

b)

Time Complexity-: O(N)

c)

Space Complexity-: O(N)

 */
