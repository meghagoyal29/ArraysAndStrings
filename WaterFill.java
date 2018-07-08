package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int trap(int[] height) {
    int fill = 0;
    int interimfill = 0;
    int currentHeight = height[0];
    
        for(int  i=0; i< height.length; i++){
            if(height[i] >= currentHeight){
                fill += interimfill;
                currentHeight= height[i];
            }
            else{
                interimfill += currentHeight - height[i];
            }
                
        }
        return fill;
    }
}

public class WaterFill {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
       // while ((line = in.readLine()) != null) {
            //int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {0,0,4,0,0,6,0,0,3,0,5,0,1,0,0,0};
            int ret = new Solution().trap(height);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
       // }
    }
}