import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OddNums {
	public static void main(String[] args) {
		//System.out.println(oddNumbers(2,5));
		String[] words = {"a","b","ba","bca","bda","bdca"};
		String[] words1 = {"a" , 
				"zxb" ,
				"ba" ,
				"bca" , 
				"bda" , 
				"bdca" , 
				"zxbe" , 
				"azxbe",  
				"azxpbe"};
		int[] arr = {5,1,2,2,3,1};
		int[] numbers = {3,1,6,10};
		//System.out.println(longestChain(words1));
		Float f1 = new Float("3.0");
		//System.out.println(f1.intValue()+f1.byteValue()+f1.doubleValue());
		//System.out.println(degreeOfArray(arr));
		System.out.println(countSum(numbers));
		}
    /*
     * Complete the oddNumbers function below.
     */
    static int[] oddNumbers(int l, int r) {
        /*
         * Write your code here.
         */
        int firstOddNum= l%2==0?l+1:l;
        int lastOddNum = r%2==0?r-1:r;
        System.out.println(firstOddNum+""+""+lastOddNum);
        int count = (lastOddNum - firstOddNum)/2 +2;
        int[] result = new int[count];
        for(int i= firstOddNum, j=0; i<=lastOddNum;i++){
            result[j]=i;
            i++;
            j++;
        }
        return result;
    }    /*
     * Complete the degreeOfArray function below.
     */
    static int degreeOfArray(int[] arr) {
        Map<Integer, List<Integer>> mapOfSizes = new HashMap<>();
        Map<Integer, Integer> mapOfDistances = new HashMap<>();
        for(int i=0; i<arr.length;i++){
            if(mapOfSizes.containsKey(arr[i])&&mapOfDistances.containsKey(arr[i])){
               List<Integer> list =  mapOfSizes.get(arr[i]);
                if(i-list.get(list.size()-1)< mapOfDistances.get(arr[i])){
                    mapOfDistances.put(arr[i],i-list.get(list.size()-1));
                }
                list.add(i);
                
            }else{
                List<Integer> list =  new ArrayList<Integer>();
                list.add(i);
                mapOfSizes.put(arr[i],list);
                mapOfDistances.put(arr[i],arr.length);
            }
            
        }
        int minSize = arr.length;
        for(Integer number: mapOfDistances.keySet()){
            if(minSize>mapOfDistances.get(number))
                minSize = mapOfDistances.get(number);
        }
        return minSize;
    }


    /*
     * Complete the countSum function below.
     */
    static long countSum(int[] numbers) {
    long sum=0L;
       for(int i=0;i<numbers.length;i++){
            if(numbers[i]==1){
                sum++;
                continue;
            }
           for(int j=1;j<=numbers[i]/2;j+=2){
               if(numbers[i]%j==0){
                   sum+=j;
                   //System.out.println("numbers[i]"+numbers[i]+"j"+j+"Sum"+sum);
               }
               }
           if(numbers[i]%2!=0){
                   sum+=numbers[i];
               }
       }
        return sum;
    }

    DictionaryAuto d;
    public List<String> input(char c) {
        List<String> sentences = new ArrayList<String>();
        
        if(d==null||d.root.children==null){
            return sentences;
        }
        TreeNode currentNode = d.root;
       List<String> childList = ((Collection<String>) currentNode.children).stream()
        .filter(word -> word.indexOf(c)==0).collect(Collectors.toList());
	return childList;
        
    }

    
    static int longestChain(String[] words) {
    	int longestString = createDictionary(words); 
    	//perform breadth first search in the nodes to find the deepest level
    	
    	return longestString;

    }
	private static int createDictionary(String[] words) {
		Dictionary d = new Dictionary();
    	int longestStringChain = 0;
    	for(String str: words) {
    		int size = 1;
    		NodeData currentRoot = d.root;
    		char[] chars = str.toCharArray();
    		
    		for(int i=0;i<chars.length;i++) {
    			if(currentRoot.children[26]!= null && currentRoot.children[26].data==1) {
    					size++;
    					//System.out.println((char)currentRoot.index+""+size);
        		}
    			if(currentRoot.children[chars[i]-'a'] != null && currentRoot.children[chars[i]-'a'].data==1) {
    				currentRoot = currentRoot.children[chars[i]-'a'];
    			}else {
    				currentRoot.children[chars[i]-'a']=new NodeData();
    				currentRoot.children[chars[i]-'a'].data=1;
    				currentRoot.children[chars[i]-'a'].index=chars[i];
    				currentRoot = currentRoot.children[chars[i]-'a'];
    			}
    			currentRoot.children[26]=new NodeData();
    			currentRoot.children[26].data = 1;
    		}
    		
    		if(size > longestStringChain) {
    			longestStringChain = size;
    		}
    		//System.out.println(size +" "+ longestStringChain);
    			
    	}
    	return longestStringChain;
	}
    
}
class NodeData{
	int data; //contains zero or 1 depending upon whether the node is present in the children or not and last is for *
	int index;
	NodeData[] children ;
	public NodeData() {
		children = new NodeData[27];
	}
}
class Dictionary{
NodeData root;
public Dictionary() {
	root = new NodeData();
	root.data = '*';
}

}

class DictionaryAuto{
    TreeNode root;
public DictionaryAuto(){
   root = new TreeNode();
    root.data  = "#";
    root.children = new HashMap<String, TreeNode>();
}
    
}
  class TreeNode{
    Map<String, TreeNode> children;
    String data;
    boolean isWord;
    int hotness;
}   