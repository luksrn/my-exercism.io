package dojo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LineCounterTest {
	
	LineCounter instance = new LineCounter();
	
 	private String code;

 	private int expectedLineOfCodes;

 	public LineCounterTest(String code, int expectedLineOfCodes) {
 		this.code= code;
 		this.expectedLineOfCodes= expectedLineOfCodes;
     }
	
	@Test
	public void testLineConter() {
		assertEquals( expectedLineOfCodes, instance.count( code ).intValue());
	}
	
	@Parameters(name= "{index}: Code has {1} lines")
 	public static Collection<Object[]> data() {
 		return Arrays.asList(new Object[][] { 
 			
 				{ "\n\n\n\n //Teste\n", 0 }, 
 				
 				{ "package dojo;\n\n\n\n //Teste\n", 1 }, 
 				
 				{ "package dojo;\n" +
				"\n" +
				"import org.junit.Assert;\n" +
				"import org.junit.Test;\n" +
				"\n" +
				"/** Comentário JAva Comentário JAva linha dois */\n" +
				"public class LineCounterTest {}\n", 4 },
 				
                 { "package dojo;\n" +
        			"\n" +
        			"import org.junit.Assert;\n" +
        			"import org.junit.Test;\n" +
        			"\n" +
        			"/** Comentário JAva\n"
        			+ " Comentário JAva linha dois */\n" +
        			"public class LineCounterTest {}\n", 4 }, 
                 
                 {"// This file contains 3 lines of code\n" +
             			"public interface Dave {\n" +
            			"/**\n" +
            			"* count the number of lines in a file\n" +
            			"*/\n" +
            			"int countLines(File inFile); // not the real signature!\n" +
            			"}\n" +
            	        "\n", 3 },
                 
                 {"/*****\n" +
         				"* This is a test program with 5 lines of code\n" +
        				"* \\/* no nesting allowed!\n" +
        				"//*****//***/// Slightly pathological comment ending...\n" +
        				"\n" +
        				"public class Hello {\n" +
        				"public static final void main(String [] args) { // gotta love Java\n" +
        				"// Say hello\n" +
        				"System./*wait*/out./*for*/println/*it*/(\"Hello/*\");\n" +
        				"}\n" +
        				"\n" +
        				"}\n", 5 } 
            	 });
     }

}
