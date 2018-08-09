
public class Arbitrage {
	public static void main(String[] args) {
		String[] quotes = {
				"0.5795 0.5173 1.2223",
				"0.7931 0.5663 1.0012",
				"1.4318 1.4705 1.3352",
				"1.3413 0.8072 1.0355",
				"1.2767 1.1696 0.5423",
				"0.6903 0.7520 0.5195",
				"1.3832 0.7238 1.4037",
				"0.5739 1.4304 0.9906",
				"0.5648 0 0",
		"0.8033 0.9961 1.2498"};
		arbitrage(quotes);
	}
	static int[] arbitrage(String[] quotes) {
		if(quotes==null||quotes.length==0) {
			return null;
		}
		int[] profits = new int[quotes.length];
		int index = 0;
		for(String str: quotes) {
			double initialAmount = 100000d;
			double nextamount = 0d;
			String[] quotesSeparated = str.split(" ");
			double profit = 0;
			if(quotesSeparated.length<3) {
				profits[index] = 0;
				index++;
				continue;
			}
			for(int i = 0; i< quotesSeparated.length;i++) {
        		nextamount = (initialAmount/Double.parseDouble(quotesSeparated[i]));
        		initialAmount = nextamount;
        	}
			profit = Math.floor(initialAmount - 100000d);
			profits[index] = (int) (profit>0?profit:0);
			index++;

		}
		return profits;
	}
}
