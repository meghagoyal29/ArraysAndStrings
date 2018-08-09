import java.util.Scanner;

public class PreOrderCheck {
	public static void main(String[] args) {
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
			System.out.println(CheckPreOrder(tree,0,treeCount)?"YES":"NO");
		}
	}
	
	public static boolean CheckPreOrder(int[] a, int startIndex, int endIndex) {
		boolean checkLeft  = true;
		boolean checkRight  = true;
		int startLeft = 0;
		int endLeft = 0;
		int startRight = 0;
		int endRight = 0;
		if(startLeft>=endLeft||startRight>=endRight)
		{
			return false;
		}
		for(int i = startIndex; i< endIndex-1;i++) {
			// potential left subtree
			startLeft = i;
			if(a[i+1]<=a[i]) {
				while(a[i]>=a[i+1]) {
					i++;
				}
				endRight = i>0?i-1:0;
			}else{
				//potential right subtree
				startRight = i;
				while(a[i]<a[i+1])
					i++;
				endRight = i>0?i-1:0;
				
				}
			if(endLeft+1!=startRight)
				return false;
			checkLeft= CheckPreOrder(a,startLeft,endLeft);
			checkRight= CheckPreOrder(a,startRight,endRight);
			
				return checkLeft&&checkRight;
			
		}
	}
}
