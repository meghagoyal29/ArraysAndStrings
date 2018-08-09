import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Election {
	public static void main(String[] args) {
		String[] votes = {"Alex" + 
				"Michael", 
				"Harry",
				"Dave", 
				"Michael", 
				"Victor", 
				"Harry", 
				"Alex", 
				"Mary", 
				"Mary"};
		System.out.println(electionWinner(votes));
		
	}
	static String electionWinner(String[] votes) {
		Map<String, Integer> votesMap = new TreeMap<>();
		int winningcount =0; 
		String winner = "";
		for(int i = votes.length-1; i>=0;i--) {
			String vote = votes[i];
			if(votesMap.containsKey(vote)) {
				int votesCount = votesMap.get(vote)+1;
				votesMap.put(vote, votesCount);
				if(votesCount>winningcount) {
					winningcount = votesCount;
					winner = vote;
				}
			}else {
				votesMap.put(vote, 1);
			}
		}
		
		return winner;

    }

}
