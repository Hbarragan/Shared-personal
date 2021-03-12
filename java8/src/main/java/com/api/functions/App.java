package com.api.functions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class App 
{
    public static void main( String[] args )
    {
    	String prefix = "SR. ";
    	
		//str -> str.toLowerCase()   ---     String::toLowerCase
		//(str, i) -> str.substring(i)   ---   String::substring
		//number -> String.valueOf(number)   ---   String::valueOf
		//(originalString) -> new String(originalString)   ---   String::new
		//(someOtherString) -> someString.concat(someOtherString)   ---   someString::concat

        System.out.println( process("Hector Barragan", prefix::concat) );
        System.out.println( process2("Hector Barragan", 7, String::substring));
    }

	private static String process2(String str, int i,
			BiFunction<String, Integer, String> processor) {
		
		return processor.apply(str, i);
	}

	private static String process(String str, Function<String, String> processor) {
		
		return processor.apply(str);
	}
}