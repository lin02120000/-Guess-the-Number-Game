package exercise05;
/*
 * Author: Stanley Pieda
 * Date: March 16, 2022
 * Modified by: **** Lin Chen ***
 * Modified Date: **** August,5,2022. ****
 * Description: Starter Code / Sample Solution Exercise 05
 * Starter Code Note: Use the pseudocode and complete the main method
 */

import java.util.Scanner;

/*
 * This class only contains method main, to drive the application.
 */
public class Exercise05 
{
	/*
	 * This program runs a menu and allows the user to change and 
 * print data from the User,CheckGuessResult and HighLowGame class.
	 */
	public static void main(String[] args) 
	{
			// ToDo: See Pseudocode and / or flowchart
		 User user = new User();
		 HighLowGame game = new HighLowGame();
		 String CONTINUE_GAME = "Y";
		 String EXIT_GAME = "N";
		 String shouldContinue = EXIT_GAME;
	
		 do 
		 {
			 if(shouldContinue.equals(shouldContinue)) 
			 {
				System.out.print("it's in");
			    game.reset();
			 }
			 game.run();
			 shouldContinue = user.inputString("Would you like to play again? (Y/N)");
		 }
		 while(shouldContinue.equals(CONTINUE_GAME));
		 System.out.println("Program by Lin Chen" );
	}       
}


