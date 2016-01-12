import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pangrams {

    private static final List<Character> ALPHABET = Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    );

    public static boolean isPangram(String text){
        return differentLetters(text) == ALPHABET.size();
    }

    private static int differentLetters(String text){
        Map<Character,List<Character>> mapping = text.chars()
                .mapToObj(c -> (char) c)
                .map(letter -> Character.toUpperCase(letter))
                .filter(letter -> ALPHABET.contains(letter))
                .collect(Collectors.groupingBy(Character::valueOf));
        return mapping.keySet().size();
    }
}
