import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arrayabcd {

	public static void main(String[] args ) {

		int[] arr = new int[] {1,2,3,4,5,6,10,11,0};
		Map<Integer, List<Integer>>map = new HashMap<>();

		for(int i =0;i<8;i++) {
			for(int j=i+1; j<9;j++) {
				if(i!=j) {
					int sum = arr[i]+arr[j];
					List<Integer> indexList = new ArrayList<>();
					indexList.add(i);
					indexList.add(j);
					if(map.containsKey(sum)) {
					//	if(!indexList.containsAll(map.get(sum))) {
							System.out.println(indexList+""+map.get(sum));	
						//}
					}else {
						map.put(sum, indexList);
					}

				}
			}
		}
	}
}

