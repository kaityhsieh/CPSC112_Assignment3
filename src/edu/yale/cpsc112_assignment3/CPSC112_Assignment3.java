package edu.yale.cpsc112_assignment3;

import java.util.Random;

public class CPSC112_Assignment3 {

  public static String mySecret = "";
  public static boolean DEBUG = true;
  public static Random r = new Random();

  public static void main(String[] args) {
    makeMySecret();
    isGameOver("1234");
    isGameOver("4321");
    isGameOver("2567");
    isGameOver("1432"); 
  }

  public static void makeMySecret() {
     // Part 1 code goes here (please leave the next few lines at the end of the makeMySecret method)
	  
	  boolean DEBUG = false; 
	  
	  Random r = new Random(); 
	  int firstDigit = 0;
	  int secondDigit = 0;
	  int thirdDigit = 0;
	  int fourthDigit = 0;
	  
	  //why does it say secondDigit must return a boolean??
		  firstDigit = r.nextInt(7) + 1; 
		  secondDigit = r.nextInt(7) + 1; 
		  while(secondDigit == firstDigit) {
			  secondDigit = r.nextInt(7) + 1; 
		  }
		  thirdDigit = r.nextInt(7) + 1; 
		  while(thirdDigit == secondDigit || thirdDigit == firstDigit) {
			  thirdDigit = r.nextInt(7) + 1; 
		  }
		  fourthDigit = r.nextInt(7) + 1; 
		  while(fourthDigit == thirdDigit || fourthDigit == secondDigit || fourthDigit == firstDigit) {
			  thirdDigit = r.nextInt(7) + 1;  
		  }
		DEBUG = true; 
	//^no idea what this line is. Just tried to put it in to return a boolean 
			 
	  if(DEBUG)
	  { 
		  /*String mySecret = new String(); 
		  mySecret = firstDigit + secondDigit + thirdDigit + fourthDigit; */
		  
		  //PROBLEM: how do I make this into a string of concatenated numbers? 
		  //right now they are adding up... 
		  System.out.println("first number:" + firstDigit);
		  System.out.println("second number:" + secondDigit);
		  System.out.println("third number:" + thirdDigit);
		  System.out.println("fourth number:" + fourthDigit);
		//  String mySecret = firstDigit + secondDigit + thirdDigit + fourthDigit;
	    //  int mySecret = firstDigit + secondDigit + thirdDigit + fourthDigit; 
		  System.out.println(mySecret);
	  }
	 
	  if (DEBUG)
    {
       System.out.println(mySecret);
    }
	 
  }

  /*public static boolean isGuessValid(String input) {
    // Part 2 code goes here
  } 
  */

  public static boolean isGameOver(String input) {
	  
	  int correctDigits = 0; 
	  int correctSpots = 0; 
	  
	  //input = 1234
	  //mySecret = 5267
	  
	  //PROBLEM: Can i call mySecret from the previous method? 
	  //this part counts the number of correct digits
	  //need to parseInt these characters 
	  for (int i = 0; i < 4; i++) {
		  for (int j = 0; j < 4; j++) {
	//		  if (input.charAt(i)) == mySecret.charAt(j)) {
			  if (Integer.parseInt(input.substring(i, i+1)) == Integer.parseInt(mySecret.substring(j, j+1))) {
				  correctDigits++;
			  }
		  }
	  }
	  
	  //this part counts the number of digits in the right spot 
	  for (int i =0; i < 4; i++) {
		  if (input.indexOf(i) == mySecret.indexOf(i)) {
			  correctSpots++; 
		  }
	  }
	  
	  System.out.println("Guess:" + input);
	  System.out.println("Result:" + correctDigits + "," + correctSpots);
	  System.out.println(); 
	  
	  if (correctDigits == 4 && correctSpots == 4) {
		  return true; 
	  }
	  else {
		  return false;
	  }
  }
}
