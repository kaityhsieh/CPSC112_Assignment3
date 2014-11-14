package edu.yale.cpsc112_assignment3;

import java.util.Random;

public class CPSC112_Assignment3 {

  public static String mySecret = "";
  public static boolean DEBUG = false;
  public static Random r = new Random();
  public static int correctDigits = 0; 
  public static int correctSpots = 0; 
  public static int exceptionsRemaining = 3; 
  public static int highestGuess = 0;
  public static boolean iJustLied = false; 

  public static void main(String[] args) {
    makeMySecret();
    isGuessValid("1278");
    isGuessValid("12735");
    isGameOver("1234");
    isGameOver("4321");
    isGameOver("2567");
    isGameOver("1432"); 
    isGameOver("1235");
    isGameOver("1236");
  }

  public static void makeMySecret() {
     // Part 1 code goes here (please leave the next few lines at the end of the makeMySecret method)
	  
	  int firstDigit = 0;
	  int secondDigit = 0;
	  int thirdDigit = 0;
	  int fourthDigit = 0;
	  
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
			  fourthDigit = r.nextInt(7) + 1;  
		  }
			 
		  mySecret = firstDigit + "" + secondDigit + thirdDigit + fourthDigit;
		  
		  if (DEBUG)
		    {
		       System.out.println("Secret: " + mySecret);
		    }

  }

  public static boolean isGuessValid(String input) {
  }


  public static boolean isGameOver(String input) {
	 
	  
  }

}
