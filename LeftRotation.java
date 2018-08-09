import java.util.*;

/**
 * @author megha
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 *
 */
public class LeftRotation {

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
         int rotations = 0;
        if(n>k){
            rotations = k;
        }else
        {
            rotations = n%k;
        }
        for(int a_i=0; a_i+rotations < n; a_i++){
            System.out.print((a[a_i+rotations])+" ");
        }
        for(int i=0; i < rotations; i++){
            System.out.print(a[i]+" ");
        }
        
    }
}

