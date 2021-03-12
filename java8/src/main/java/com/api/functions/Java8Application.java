package com.api.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Java8Application {

	public static void main(String[] args) {
		
		//DATA
		  
        List <Person> people = new ArrayList<>();
        Person p =  new Person("Hector","Barragan",30);
        Person p2 =  new Person("Yolanda","Moya",33);
        Person p3 =  new Person("Rafael","Moya",61);
        Person p4 =  new Person("Dylan","Barragan",16);
        people.add(p2);
        people.add(p3);
        people.add(p);
        people.add(p4);
        
		List<String> myList =
			    Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		
		ArrayList<Integer> myListNumbers = new ArrayList<Integer>(Arrays.asList(12,23,24)); 
		
        
		//STREAM - FILTER
		System.out.println("#STREAM - FILTER");
		
		
		Stream<Integer> st = myListNumbers.stream();
		System.out.println("Search value 23 count:"+ st.filter(Predicate.isEqual(23)).count());
		
		System.out.println("Search start with 'c';");
		myList
	    .stream()
	    .filter(s -> s.startsWith("c"))
	    .map(String::toUpperCase)
	    .sorted()
	    .forEach(System.out::println);
	    
		
        
        System.out.println("Search name start with 'H';");
        people
	    .stream()
	    .filter(s -> s.name.startsWith("H"))
	    .forEach(System.out::println);

        System.out.println("Search adults;");
        people
	    .stream()
	    .filter(s -> s.age>18)
	    .forEach(System.out::println);

		
        
        System.out.println("#Order");
		
		//Ordenar
	    String[] names = {"Señor Paco", "Mujer Laia", "Niña Ainara","Niño Juan"};
        Arrays.sort(names, Comparator.comparing(name -> name.split(" ")[1]));
        Arrays.sort(names, Comparator.comparing((String name) -> name.split(" ")[1]).reversed());
        
        System.out.println("Order by name;");
        System.out.println(Arrays.toString(names));
        
      
        System.out.println("Order by age > ;");
        Collections.sort(people, (o1, o2) -> {
	    	 return o1.age.compareTo(o2.age);
	    	 });
	     
        System.out.println("Order by age < ;");
        Collections.sort(people, (o1, o2) -> {
        	return o2.age.compareTo(o1.age);
        	});
        
	    List<String> sample = Arrays.asList("a","f","g","k");
	    Collections.sort( sample , (o1, o2) -> o1.compareTo(o2));
	     
	
        
        System.out.println(people.toString());
        
        //interfaz funcional
        
        
        
        
        
     
	}
	
	
    public static String firstName(String name) {
    	return name.split(" ")[1];
    }

}
