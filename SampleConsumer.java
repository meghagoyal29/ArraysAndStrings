import java.util.function.Consumer;

public class SampleConsumer implements Consumer<String>{

	@Override
	public void accept(String t) {
		System.out.println(t);
		
	}
}
