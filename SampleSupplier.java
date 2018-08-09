import java.util.*;
import java.util.List;
import java.util.function.Supplier;

public class SampleSupplier implements Supplier<Integer>{
	
	List<Integer> intList = Arrays.asList(1,2,3,4,5);
	
	int i = 0;

	@Override
	public Integer get() {
		try {
		 return intList.get(i++);
		}catch(Exception e) {
			return null;
		}
	}
}
