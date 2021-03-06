package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		
		 String acronymString = Character.toString (phrase.charAt(0));//Grab first Character
			
			for(int i = 0; i <phrase.length(); i++ )
			{
				if(Character.isLetterOrDigit (phrase.charAt(i)))// move on we already have our char
				continue;
				i++;
				while (!(Character.isLetterOrDigit(phrase.charAt(i))))// skip all non char in between
					i++;
				acronymString  = acronymString + Character.toString (phrase.charAt(i));	
						
			}		
			
			return (acronymString.toUpperCase()) ;
		//return null;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			return ((sideOne == sideTwo ) && (sideTwo == sideThree));
			
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			return (sideOne==sideTwo) || (sideOne == sideThree) || (sideTwo==sideThree);
			//return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			return !(sideOne == sideTwo) && !(sideOne == sideThree) && !(sideTwo == sideThree);
			
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		

		int total = 0;
		
		for(int i = 0; i < string.length(); i ++) {
			
			char c = Character.toUpperCase(string.charAt(i)) ;// use c to shorted the expressions that follow
			
			// A, E, I, O, U, L, N, R, S, T =1
			if(  c == 'A' ||  c == 'E'||  c == 'I'||  c == 'O'||c == 'U'
					||c == 'L' ||c == 'N' ||c == 'R' ||c == 'S' ||c == 'T')
				
				total = total + 1;
			// D, G = 2
			else if(c == 'D'|| c == 'G')
				total = total + 2;
			
			 // B, C, M, P = 3
			else if(c == 'B' ||c == 'C' || c == 'M' || c == 'P')
				total = total + 3;
			
			//F, H, V, W, Y = 4
			else if( c == 'F'||c ==  'H' || c ==  'V' || c ==  'W' || c == 'Y')	
				total = total + 4;
			
			//K = 5	
			else if (c == 'K')
				total = total + 5;
			//J, X = 8
			else if ( c == 'J' || c == 'X' )
				total = total + 8;
			// Q, Z = 10
			else 
				total = total + 10; // the two characters left Q an Z are = 10;
				
			
		}// end for loop
		
		return total;
		//return 0;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
String s = ""; // start with an empty string
		
		for(int i = 0 ; i < string.length();  i++ )
		{
			char c = string.charAt(i);
			
			if(i==0)
			{
				if (string.charAt(i) == '+')
					if (string.charAt(i+1)== '1')
					{
						i +=2;
						continue;
					}
					else
						throw new IllegalArgumentException();
			}
			
			// Parse input string and grab digits
			if (Character.isDigit(c)){
					s = s + Character.toString(c);
							
			}//end if
			
			// Beside digits, only those characters are valid 
			else if(c != '(' && c!=')' && c!= ' ' && c != '.' && c != '-' )	
				throw new IllegalArgumentException();
			else
				continue;	
			
		}// end for
		
		if((s.length() == 11) &&  (s.charAt(0)== '1') ) {
			return  s;
		}
		
			else if ((s.length()==10))
			return  s;
		else
			throw new IllegalArgumentException();
		
		//return null;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		//return null;
		HashMap <String, Integer> map = new HashMap <String, Integer>();
		//create Stringtokenizer for string
	StringTokenizer tokenizer = new StringTokenizer(string);
	
	// process input text
	while(tokenizer.hasMoreTokens())
	{
		String word = tokenizer.nextToken().toLowerCase();//get word
		//if the map contains the word
		if (map.containsKey(word)) {
			int count = map.get(word);
			map.put(word, count +1);	
		}//end if
		else map.put(word, 1);
			
	}	
		return map;
			
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		
		//TODO Write an implementation for this method declaration
				String[]splitString = string.split(" ");
				String myString = "";
			 for(int row = 0; row< splitString.length; row++  ) {
				 
				 myString += convertString(splitString[row]) + " ";
					
				}
				
				return myString.substring(0,myString.length()-1);
		//return null;
	}

	
	public static String convertString(String string) {
		
		 String s = string.toLowerCase();
		 char ch = s.charAt(0);
		
		boolean vowel;//
		if(ch == 'a' || ch =='e'||ch =='i' || ch== 'o' || ch == 'u')
		vowel = true;
	else
			vowel = false;
		
		int i =0;// will be used in the while loop below
		         // can't be declared at a lower level;
		         // will either brake the if statement or 
		         // for the last return statement
		String backString ="";
		
		if (vowel)
			return(s+"ay");
			//return(s.substring(1, s.length()-1) + )
	else {
		 backString = Character.toString(ch);
			 while(!vowel) {
				i++;
				ch = s.charAt(i);
			if(ch == 'a' || ch =='e'||ch =='i' || ch== 'o' || ch == 'u')
				{
					vowel = true;
					continue;
					}
				
				backString += Character.toString(ch);
			 }
				
		}//end else
		
		return(s.substring(i,s.length())+ backString+"ay");
		
		}//end method convertString
	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		
		//number to store calculated value
				int n =0;
				
				//convert input to a string s
				String str = Integer.toString(input);
				
				//the length of str is the exponent e
				int e = str.length();
				
				for(int i = 0; i < str.length(); i++)
				{ 
					char tempChar = str.charAt(i);
					int tempInt = Character.getNumericValue(tempChar);
					n += Math.pow(tempInt, e);
				}
				//System.out.println("The computed value is: " + n );
				return (input == n);
					
		//return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
List <Long> arrList  = new ArrayList <Long>();
	    
	    if(l ==2) {
	         arrList.add(l);
	         }
	         else {
	      
	      for(long i = 2; i<= l; i++) {
	    	  
	         while(l%i == 0) {
	        	 
	            arrList.add(i);
	            
	            l = l/i;
	            
	         }//end while
	         
	      }//end for

	   }  //end else  
		
		return arrList;
		
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			
			 String  str = string;
			 String codedString ="";
			 int rotValue = 13;
			 
			 char inStringArry[] =  string.toCharArray();
			 char myChar;
			 int tempInt =0;
			for(int i =0; i <string.length(); i++)
			{
				if(Character.isLetter(inStringArry[i])) {
					 tempInt = (char)(inStringArry[i]);
					 //The line below was found online 
					//ch3=(char)(((int)ch1[i]+shift-97)%26+97);
					if (tempInt > 96 && tempInt< 123) {
					myChar = (char)(((int)inStringArry[i] + key - 97 ) % 26 + 97);	
					codedString = codedString + myChar;
					}//end if
					
					else if(tempInt > 64 && tempInt < 91){	
						myChar = (char)(((int)inStringArry[i] + key - 65 ) % 26 + 65);	
						codedString = codedString+myChar;
					}//end if
				}
					
				else {
						myChar =inStringArry[i];
						
						codedString = codedString + myChar;
					}
					
				
			}// end for loop
			
			return codedString;
			//return null;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	
	public static boolean isPrime(int num)
	{
		for(int i =2; i< num; i++) {
			
			if(num%i == 0) 
				return false;
			    
		}
		
		return true;
	}// end method isPrime
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		int result = 0;
		for( int n = 2 ; result < i; n++) {
			
			if (isPrime(n)) {
				result ++;
				if (result  == i)
					return n;		
			}
			
		}
		
		return 0;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	public static String myReverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			String origString = "abcdefghijklmnopqrstuvwxyz";
			
			String  reverseString = myReverse(origString) ;
			String string2 = string.toLowerCase();
			char[] inputString = string2.toCharArray();
			char[] charOrigString = origString.toCharArray();
			char[] charReverseString = reverseString.toCharArray();
			
			String tempString = "";
			System.out.println(inputString);
			for(char c : inputString) {
				if(Character.isDigit(c))
					tempString += c;
				for(int i= 0; i<26; i++)
				{
					if(charOrigString [i] == c)
						tempString += charReverseString[i];		
				}//end inner for
				
			}//end outer for
			System.out.println(tempString);
			String finalString = "" + tempString.charAt(0);
			
			for (int i = 1; i < tempString.length(); i++) {
				
				if (i%5 == 0)
					finalString += " ";
				    
				finalString +=tempString.charAt(i) ;
				
				
			}//enf for loop
			return finalString;
			//return null;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			String encodeString = encode(string);
			 String finalString = encodeString.replaceAll("\\s", "");
			 return finalString;
			 
			//return null;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		
		 boolean[] checkChar = new boolean[26]; 
		  
	        // For indexing in checkChar[] 
	        int index = 0; 
	  
	        // Traverse  string
	        for (int i = 0; i < string.length(); i++) 
	        { 
	            // If uppercase character, subtract 'A' 
	            // to find index. 
	            if ('A' <= string.charAt(i) &&  
	                    string.charAt(i) <= 'Z') 
	                    index = string.charAt(i) - 'A'; 
	  
	                // If lowercase character, subtract 'a' 
	                // to find index. 
	            else if('a' <= string.charAt(i) &&  
	                        string.charAt(i) <= 'z') 
	                              
	                index = string.charAt(i) - 'a'; 
	  
	            // check current character 
	            checkChar[index] = true; 
	        } 
	  
	        // Return false if any character is unchecked 
	        for (int i = 0; i <= 25; i++) 
	            if (checkChar[i] == false) 
	            	return(false);
	             // If all characters are accounted for; 	
	        return (true); 
	        
		//return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		
		try
		{
			return given.plus(1000000000,ChronoUnit.SECONDS);
			
		}
		catch (Exception e)
		{
			
			LocalDateTime dateTime = ((LocalDate)given).atStartOfDay();
			return dateTime.plus(1000000000,ChronoUnit.SECONDS);
		}
		//return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		
		int sum = 0;//this hold how result
		for(int n =0; n<i; n++) // n is every number before i
			for(int m=0; m<set.length; m++)
			{
				
				if (n%set[m]==0)
				{
					sum +=n;
					break;
				}
			}
				
				
		return sum;
	
		
		//return 0;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		String myString = string.replace("?","");// replace ? with null
		String [] words = myString.split(" ");
		
		int a = Integer.parseInt(words[2]);
		int b = 0;
		
		
		switch (words[3]){
		case "plus": 
					{
						b =Integer.parseInt(words[4]); 
						return a+b;
						}
		case "minus": 
					{
						b =Integer.parseInt(words[4]); 
						return a-b;
					}
		
		case "multiplied":
					{
						b =Integer.parseInt(words[5]);
						return a*b;
					}
		
		case "divided":
					{
						b =Integer.parseInt(words[5]);
						return a/b;
					}
					
		default: return 0;
		
		}//end switch statement
		
		//return 0;
	}

}
