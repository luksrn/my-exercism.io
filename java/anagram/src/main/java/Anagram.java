import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class Anagram {
  	private Map<Character,Integer> statistics = new HashMap<>();
	
	public Anagram(String word) {
		statistics = statisticsOf(word);
	}
	
	private Map<Character, Integer> statisticsOf(String word){
		return word.chars()
				.mapToObj(e->(char)e)
				.collect(toMap(Character::toLowerCase, e->1, Integer::sum));
	}
	
	public List<String> match(List<String> words) {
		return words.stream()
					.filter( this::isAnagram )
					.collect(toList());		
	}
		
	private boolean isAnagram(String word) {
		return statisticsOf(word).equals(statistics);		
	}
}
