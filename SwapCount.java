import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SwapCount {

    static long countInversions(int[] arr) {
        int sortedLength = arr.length-1;
        long swaps = 0;
        
        while(sortedLength>0){
            for(int i= 0; i<sortedLength; i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    swaps++;
                }
                if(swaps==0)
                	break;
            }
          for(int i=0; i<arr.length;i++)
        	  System.out.print(arr[i]+" ");
          System.out.println();
            sortedLength--;
        }
        return swaps;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for(int a0 = 0; a0 < t; a0++){
//            int n = in.nextInt();
//            int[] arr = new int[n];
//            for(int arr_i = 0; arr_i < n; arr_i++){
//                arr[arr_i] = in.nextInt();
//            }
    	int[] arr = {2,1,3,1,2};
              
            long result = countInversions(arr);
            System.out.println(result);
        }
        //in.close();
    }
//}
