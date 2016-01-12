import static java.util.stream.IntStream.range;
import java.lang.IllegalArgumentException;

public class Hamming {

	public static int compute(String reference, String tested) {
    if(reference.length() != tested.length()){
      throw new IllegalArgumentException();
    }
    return (int) range(0, reference.length() )
						.filter( i -> reference.charAt(i) != tested.charAt(i) ).count();
	}
}
