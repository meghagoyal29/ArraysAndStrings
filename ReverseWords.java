package LeetCode;

public class ReverseWords {
	
	public static void main(String[] args ) {
		
	char[] input = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
	reverseWords(input, 0,input.length, true);
		for(char c : input) {
			System.out.print(c);
		}
	}

	private static void reverseWords(char[] input, int left, int right ,boolean isSentence) {
	
	for(int i=0; i<(right-left)/2;i++) {
		swap(input, left+i,(right-1-i));
	}
	if(isSentence) {
	int leftStartWord = left;
	for(int i=left; i<right;i++) {
		if(input[i]!=' ') {
			continue;
		}else {
			reverseWords(input, leftStartWord, i, false);	
			leftStartWord=i+1;
		}
	}
	reverseWords(input, leftStartWord, right, false);
	}
	}

	private static void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i]=input[j];
		input[j]=temp;
		
	}

}
