import java.util.*;

public class Tries {
	private static Node root;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			char[] array = contact.toCharArray();
			if (op.equals("add")) {
				if (root == null) {
					root = new Node();
					root.parent = null;
					root.data = '*';
					root.children = new HashMap<Character, Node>();
				}
				add(array, root);
			}
			if (op.equals("find")) {
				if (root == null || root.children.keySet().size() == 0)
					System.out.println(0);
				else
					System.out.println(find(array, root));
			}
		}
	}

	private static int find(char[] array, Node currentPos) {
		for (char c : array) {
			if (!currentPos.children.containsKey(c)) {
				break;
			}
			currentPos = currentPos.children.get(c);
		}
		int index = new String(array).indexOf(currentPos.data);
		if (index != array.length - 1)
			return 0;
		return findSubtree(currentPos);
	}

	private static int findSubtree(Node currentPos) {
		int childCount = 0;
			for (Character c : currentPos.children.keySet()) {
				if(c=='*') {
					childCount++;
					continue;
				}
				childCount = childCount + findSubtree(currentPos.children.get(c));
			}
			
			return childCount;
		}
		
	

	private static void add(char[] array, Node currentPos) {
		for (char c : array) {
			if (!currentPos.children.containsKey(c)) {
				break;
			}
			currentPos = currentPos.children.get(c);
		}
		int index = new String(array).indexOf(currentPos.data);
		if (index == -1) {
			buildSubtree(array, currentPos, 0);
		} else {
			buildSubtree(array, currentPos, index);
		}
	}

	private static void buildSubtree(char[] array, Node currentPos, int i) {
		for (; i < array.length; i++) {
			Node node = new Node();
			node.data = array[i];
			node.children = new HashMap<Character, Node>();
			currentPos.children.put(array[i], node);
			currentPos = node;
		}
		currentPos.children.put('*', null);
	}
}

class Node {
	HashMap<Character, Node> children;
	Character data;
	Node parent;

	boolean isCompleteWord() {
		if (children.containsKey('*'))
			return true;
		return false;
	}
}
