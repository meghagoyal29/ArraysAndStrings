import java.util.*;

public class Primality {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		for(int a0 = 0; a0 < p; a0++){
			int n = in.nextInt();
			System.out.println(checkPrime(n));

		}
	}

	private static String checkPrime(int n) {

        if(n<2){
            return "Not prime";
        }
        for(int i=2; i<= Math.sqrt(n); i++){
            if(n%i == 0)
                return "Not prime";
        }
        return "Prime";
    }
	}
