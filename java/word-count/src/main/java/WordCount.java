import java.util.Map;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toMap;

public class WordCount {

	public Map<String, Integer> Phrase(String phrase) {
		return Stream.of(phrase.split("\\s*[^a-zA-Z0-9]+\\s*"))
							.collect(toMap(String::toLowerCase, e -> 1, Integer::sum));
	}
}
