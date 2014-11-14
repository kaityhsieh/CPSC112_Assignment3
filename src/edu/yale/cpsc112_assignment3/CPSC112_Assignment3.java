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
    // Part 2 code goes here
		  
		  try {
			  
			  //divide the input into 4 individual strings 
			  String firstDigit = new String(input.substring(0,1));
			  String secondDigit = new String(input.substring(1,2));
			  String thirdDigit = new String(input.substring(2,3));
			  String fourthDigit = new String(input.substring(3,4));
			  
			  //convert the strings to int
			  int finalFirstDigit = Integer.parseInt(firstDigit);
			  int finalSecondDigit = Integer.parseInt(secondDigit);
			  int finalThirdDigit = Integer.parseInt(thirdDigit);
			  int finalFourthDigit = Integer.parseInt(fourthDigit);
			  
			  //checking if all the digits are < 7 
			  if (finalFirstDigit > 7 || finalSecondDigit > 7 || finalThirdDigit > 7 || finalFourthDigit > 7) {
				  System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
				  return false; 
			  }
			 
			  //checking if all the digits are > 1
			  else if (finalFirstDigit < 1 || finalSecondDigit < 1 || finalThirdDigit < 1 || finalFourthDigit < 1) {
				  System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
				  return false; 
			  }
				  
			  //checking if any of the digits repeat
			  else if (finalFirstDigit == finalSecondDigit || finalFirstDigit == finalThirdDigit || finalFirstDigit == finalFourthDigit){
				  System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
				  return false;
			  }
			  else if (finalSecondDigit == finalThirdDigit || finalSecondDigit == finalFourthDigit){
				  System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
				  return false; 
			  }
			  else if (finalThirdDigit == finalFourthDigit){
				  System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
				  return false; 
			  }
			  else {
				  //checking if the input is 4 digits 
				  if (input.length() != 4) {
					  System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
					  return false; 
				  }
			  }
			  	return true;
		  	}	
		  
	 catch (Exception e)
	 {
		 System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
		 return false;
	 }
  }


  public static boolean isGameOver(String input) {
		 
	  if (Integer.parseInt(input) < highestGuess) {
		  if (exceptionsRemaining > 0) {
			  exceptionsRemaining--;
		  }
		  System.out.println("Your guess was lower than allowed. You have " + exceptionsRemaining + " exceptions remaining.");
	  }
	  else if (Integer.parseInt(input) > highestGuess) {
		  highestGuess = Integer.parseInt(input); 
	  }
	  
	  if (exceptionsRemaining == 0 && Integer.parseInt(input) > Integer.parseInt(mySecret)) {
		  System.out.println("You're out of exceptions and you've guessed too high! The secret was " + mySecret + ".");
		  return true;
	  }
	  
	  if(isGuessValid(input) == true){
		  
		  //run the lie 33% of the time
		  int chanceOfLying = r.nextInt(100);
		  
		  //this part counts the number of correct digits
		  for (int i = 0; i < 4; i++) {
			  for (int j = 0; j < 4; j++) {
				  if (Integer.parseInt(input.substring(i, i+1)) == Integer.parseInt(mySecret.substring(j, j+1))) {
					  correctDigits++;
				  }
			  } 
		  }
		  
		  //this part counts the number of digits in the right spot 
		  for (int i = 0; i < 4; i++) {
			  if (input.charAt(i) == mySecret.charAt(i)) {
				  correctSpots++; 
			  }
		  }
		  
		  if (chanceOfLying < 66 || iJustLied == true) {		
			 System.out.print("Guess: " + input + "; ");
		     System.out.println("Result: " + correctDigits + "," + correctSpots);
		     System.out.println(); 
		     iJustLied = false; 
		  }
		  else {
			  makeALie();
			  System.out.print("Guess: " + input + "; ");
			  System.out.println("Result: " + correctDigits + "," + correctSpots);
			  System.out.println();
			  iJustLied = true;
		  } 
		  
		  if (correctDigits == 4 && correctSpots == 4) {
			  System.out.println("You won!");
			  correctDigits = 0;
			  correctSpots = 0;
			  return false;
		  }
		  else {
			  correctDigits = 0;
			  correctSpots = 0;
			  return true;
		  }
		  
	  }

	  correctDigits = 0;
	  correctSpots = 0;
	  return true;
  }


}
