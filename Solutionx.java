import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solutionx {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
		int treeCount = in.nextInt();
		for(int i=0;i<treeCount;i++) {
			int nodes = in.nextInt();
			int[] tree = new int[nodes];
			String treeStr = in.next();
			String[] nodes1 = treeStr.split(" ");
			for(int j= 0;j<nodes;j++) {
				tree[j] = Integer.parseInt(nodes1[i]);

			}
			System.out.println(CheckPreOrder(tree,tree.length)?"YES":"NO");
		}
    }
    public static boolean CheckPreOrder(int[] a, int size) {
		
        Stack<Integer> tree = new Stack<Integer>();
 
        int root = Integer.MIN_VALUE;
 
        
        for (int i = 0; i < size; i++) {
            if (a[i] < root) {
                return false;
            }
 
            while (!tree.empty() && tree.peek() < a[i]) {
                root = tree.peek();
                tree.pop();
            }
 
            tree.push(a[i]);
        }
        return true;
    }
}