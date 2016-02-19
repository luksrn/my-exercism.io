package dojo;

import java.util.regex.Pattern;

public class LineCounter {
  
	public Integer count(String code) {
		int numberOfLines = 0;
		String onlyCode = removeComments(code);
		
		String[] lines = onlyCode.split( System.getProperty("line.separator"));
		for (String line : lines) {
			if(line.trim().isEmpty()){
				continue;
			}
			numberOfLines++;
		}

		return numberOfLines;
	}

	private String removeComments( String code ){
		Pattern multiLinePattern = Pattern.compile("/\\*.*?\\*/", Pattern.DOTALL); // remove all occurance streamed comments (/*COMMENT */ and /**COMMENT */)) from string
		Pattern singleLine = Pattern.compile("//.*?(\\n|\\$)", Pattern.DOTALL); // remove all occurance //
		
		String temp = multiLinePattern.matcher(code).replaceAll("");
		return singleLine.matcher(temp).replaceAll("\n"); 
	}
}
