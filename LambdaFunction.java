import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaFunction {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		LambdaFunction lf = new LambdaFunction();
		for (int i : numbers) {
			lf.test(lf.lambdaTest(i));
		}
		lf.lf(numbers);
		lf.optionalMethod(numbers);
	}
	
	public void optionalMethod(List<Integer> numbers) {
		Optional<Integer>  total = numbers.stream().reduce((number, sum) -> number+sum);
		total.ifPresent(System.out::println);
	}

	public void lf(List<Integer> numbers) {
				
		numbers.stream().map(eachNumber -> lambdaTest(eachNumber)).forEach(System.out::println);
		Map<String, String> mapnuu = numbers.stream().map(eachNumber -> lambdaTest(eachNumber))
		.collect(Collectors.<String,String,String>toMap(eachNumber -> eachNumber, eachNumer -> eachNumer+"hello"));
		System.out.println(mapnuu);
		numbers.stream().filter(number ->number > 3).forEach(System.out::println);
		numbers.stream().flatMap(number -> numbers.stream().filter(num ->num > number)).forEach(System.out::print);
	}		

	public void test(String testString) {
		System.out.println(testString);
	}
	

	public String lambdaTest(int number) {
		String str = "";
		for (int i = 0; i < number; i++) {
			str += "a";
		}
		return str;
	}
}
