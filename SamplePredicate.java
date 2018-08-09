import java.util.function.Predicate;

public class SamplePredicate implements Predicate<String>{

	@Override
	public boolean test(String t) {
		if(t.equals("megha"))
			return true;
		return false;
	}
}
