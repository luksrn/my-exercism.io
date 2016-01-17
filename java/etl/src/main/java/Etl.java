import java.util.List;
import java.util.Map;

public class Etl {
   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
      Map<String, Integer> transformedData = new HashMap<>();
    
		old.forEach((score, letters) -> {
			letters.stream()
				.map(String::toLowerCase)
				.forEach(letter -> transformedData.put(letter, score));			
		});
	 
		return transformedData;
   }
}
