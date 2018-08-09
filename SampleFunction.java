import java.util.function.Function;

public class SampleFunction implements Function<String, String>{

	@Override
	public String apply(String t) {
		
		return t+"nunu";
	}
}
