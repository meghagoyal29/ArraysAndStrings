import java.util.*;

public class IcsCream {

	static void solve(int[] arr, int money) {
		Map<Integer, List<Integer>> iceMAp = new HashMap<Integer, List<Integer>>();
		for(int i=0;i<arr.length-1; i++) {
			if(iceMAp.containsKey(arr[i]))
				iceMAp.get(arr[i]).add(i+1);
			else {
				List<Integer> idList = new ArrayList<Integer>();
				idList.add(i+1);
				iceMAp.put(arr[i], idList);
			}
		}
		for(int i=0;i<arr.length-1; i++) {
			int value = money - arr[i];
			if(iceMAp.containsKey(value)) {
			List<Integer> idList = iceMAp.get(value);
			Collections.sort(idList);
			int id = idList.get(0);
			if(i+1<id) {
				System.out.println((i+1)+" "+id);
				break;
			}
			else if(i+1>id) {
				System.out.println(id+" "+(i+1));
				break;
			}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int money = in.nextInt();
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int arr_i = 0; arr_i < n; arr_i++){
				arr[arr_i] = in.nextInt();
			}
			solve(arr, money);
		}
		in.close();
	}
}
