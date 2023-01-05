package exercise05;
/*
 * Author: Stanley Pieda
 * Date: March 16, 2022
 * Modified by: **** Lin Chen ***
 * Modified Date: **** August,5,2022 ****
 * Description: Starter Code / Sample Solution Exercise 05
 * Starter Code Note: Use the pseudocode and complete the reset and run methods
 */

import java.util.Random;

/*
 * to use HighLowGame class to create the game rule.
 */
public class HighLowGame {
	private User user = new User(); // internal only, no get/set
	private Random random = new Random(); // internal only, no get/set
	private int fuelAvailable;
	private int numberToGuess;
	private static final int MIN = 1; // internal only, no get/set
	private static final int MAX = 10; // internal only, no get/set

	/*
	 * No argument constructor, calls method reset to initialize the game
	 */
	public HighLowGame() 
	{
		reset();
	}

	/*
	 * Accessor for fuelAvailable
	 */
	public int getFuelAvailable() {
		return fuelAvailable;
	}

	/*
	 * Mutator for fuelAvailable
	 */
	public void setFuelAvailable(int fuelAvailable) {
		this.fuelAvailable = fuelAvailable;
	}

	/*
	 * Access for numberToGuess
	 */
	public int getNumberToGuess() {
		return numberToGuess;
	}

	/*
	 * Mutator for numberToGuess
	 */
	public void setNumberToGuess(int numberToGuess) {
		this.numberToGuess = numberToGuess;
	}

	/*
	 * to use reset method to create the fuelAvailable numbers.
	 */
	public void reset() 
	{
		// ToDo: See Pseudocode and / or flowchart
		 int sum = 0;
		 numberToGuess = random.nextInt(MAX) + 1;
		 for(int i = MIN;i < MAX + 1; i++) 
		 {
			 sum += i;	
			 
		 }
		 
//		 int j = MIN;
//		 while(j <= MAX)
//		 {
//			 sum += j;
//			 j++;
//		 }
		 
		 fuelAvailable = sum / 2;
	}

	/*
	 * to use run method to random get numbers between 1 to 10 comparing with 
	 * randomly selected number by the program. The user is given 
	 * “guess-fuel” to use, the game ends if the user guesses the number 
	 * or run out of guess-fuel.
	 */
	public void run() 
	{
		// ToDo: See Pseudocode and / or flowchart
      CheckGuessResult checkGuessResult = null;
	  String message;
	  boolean isWon = false;
	  int guessCount = 0;
	  int userNumber;
	  
	  System.out.println("Guess the number from " + MIN + " to " + MAX);
	  System.out.println("You have " + fuelAvailable + " guess-fuel remaining.");
	  while(fuelAvailable > 0 && !isWon) 
	  {
		  guessCount = guessCount + 1;
		  userNumber = user.inputInteger("guess: ");
		  fuelAvailable = fuelAvailable - userNumber;
		  if(fuelAvailable < 0) 
		  {
			  fuelAvailable = 0;
		  }
		  checkGuessResult = checkGuess(userNumber);
		  isWon = checkGuessResult.isWin();
		  message = checkGuessResult.getMessage();
		  System.out.println(message);
		  
	   }
		message = reportGameResult(isWon, guessCount);
		System.out.println(message);
	}

	/*
	 * This method examines the guess to see if it matches the numberToGuess
	 * value. To report win or no-win, with a message as well a CheckGuessResult
	 * instance is created with these results, and the reference to the
	 * CheckGuessResult object is returned.
	 */
	private CheckGuessResult checkGuess(int guess) 
	{
		boolean isWin = false;
		String message;

		if (guess == numberToGuess) 
		{
			message = "You guessed the number";
			isWin = true;
		}
		else 
		{
			if(guess < numberToGuess) {
				message = "too low, ";
			}
			else {
				message = "too high, ";
			}
			message = message + String.format(
					"%d guess-fuel remaining", fuelAvailable);
		}
		CheckGuessResult checkGuessResult = new CheckGuessResult(message, isWin);
		return checkGuessResult;
	}
	
	/*
	 * This method writes out a final result of the game (win or lose) as well
	 * as the number of guesses used by the player (i.e. the user).
	 */
	private String reportGameResult(boolean isWon, int guessCount) {
		String message;
		if(isWon) 
		{
			message = "You win! It took you ";
		}
		else 
		{
			message = "You did not win, you used ";
		}
		message = String.format(message + "%d guesses", guessCount);
		return message;
	}
}



