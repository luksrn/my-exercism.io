import java.util.HashMap;
import java.util.Map;

public class DNA {
	
	public static final Character ADENINE = 'A';
	
	public static final Character CYYOSINE = 'C';
	
	public static final Character GUANINE = 'G';
	
	public static final Character THYMINE = 'T';

	private String nucleotides;
	 
	private Map<Character,Integer> nucleotideCounts = new HashMap<>();
		
	public DNA(String nucleotides) {
		this.nucleotides = nucleotides;
		nucleotideCounts.put(ADENINE, countNucleotide(ADENINE));
		nucleotideCounts.put(CYYOSINE, countNucleotide(CYYOSINE));
		nucleotideCounts.put(GUANINE, countNucleotide(GUANINE));
		nucleotideCounts.put(THYMINE, countNucleotide(THYMINE));
	}

	private int countNucleotide(char c) {
		return (int) nucleotides.chars().filter( nucleotide -> nucleotide == c ).count();
	}
	
	public Integer count(char nucleotide) {
		if ( !nucleotideCounts.keySet().contains(nucleotide) ){
			throw new IllegalArgumentException("Invalid nucleotide!");
		}
		return nucleotideCounts.get(nucleotide);
	}

	public Map<Character,Integer> nucleotideCounts() {
		return nucleotideCounts;
	}
}
