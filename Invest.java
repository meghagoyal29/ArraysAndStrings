import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Invest {
	public static void main(String[] args) {
		System.out.println(findMax(6, "3 4 5 1 3 # 1"));
		//System.out.println(findMax(6, "3 4 5 1 3 # 1"));
	}
	
	static long findMax(int n, String tree) {
		if(tree==null||tree.length()==0) {
			return 0L;
		}
		// sum of odd levels or sum of even levels will be max.
		//nth Level has 2^n nodes
		String[] array = tree.split(" ");
		// calculate number of levels from array.length
		int level = 0;
		
		long [] sumsOddAndEven = {0,0};
		
		TreeNodee root = stringToTreeNode(tree);
		findMax(root,sumsOddAndEven,0);
		 
		return Math.max(sumsOddAndEven[0],sumsOddAndEven[1]);
	}
	static void findMax(TreeNodee root, long[] sumsOddAndEven, int level) {
		if(root==null) {
			return;
		}
		if(level%2==0) {
			sumsOddAndEven[1]+=root.val;			
		}else {
			sumsOddAndEven[0]+=root.val;
		}
		if(root.left!=null) {
			findMax(root.left, sumsOddAndEven, level+1);
		}
		if(root.right!=null) {
			findMax(root.right , sumsOddAndEven, level+1);
		}
		
	}
	public static TreeNodee stringToTreeNode(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(" ");
        String item = parts[0];
        TreeNodee root = new TreeNodee(Integer.parseInt(item));
        Queue<TreeNodee> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNodee node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("#")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNodee(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("#")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNodee(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
class TreeNodee {
	int val;
	TreeNodee left;
	TreeNodee right;
	TreeNodee(int x) { val = x; }
}

       