/**
* Monty Hall Class Problem
* @author Mitchell Pavlak
* @author Orndorff AP Comp Sci Class
**/

//model the doors as ints
import java.util.Scanner;



public class MontyHall 
{

public static Scanner keys = new Scanner(System.in);


	public static void main(String[] args) 
	{
	int numOfDoors = 3;
	int carDoor = (int) ((Math.random() * numOfDoors) + 1); //Random door between one and three
	int userDoor = getUserDoor(numOfDoors); //gets the door the user is picking
	
	int doorToReveal = revealDoor(userDoor, carDoor, numOfDoors);
	System.out.println("There is a goat behind door number: " + doorToReveal);
    //Ask whether you want to stop
    boolean swap = getUserSwap();
    if (swap == true) 
    {
    	System.out.println("Which door would you like to switch to: ");
    	int doorToSwapWith = getUserDoor(numOfDoors);
    }
	//TODO fix errors
	//TODO figure out what to do if they swap
	//TODO tell if they won

	}
	/**
	* Method asks the user whether they want to swap their door or not 
	* @return boolean that says whether the user would like to switch or not
	**/
	
	
	public static boolean getUserSwap() {
	System.out.println("Do you want to swap \'yes\' or \'no\'?");
	String answer = keys.nextLine();
	if (answer.equals("yes") || answer.equals("no")) {
	return true;
	} else 
	return false;
	}
	
	/**
	*	This method is 
	*
	*
	*
	**/
	
	
	public static int getUserDoor(int numOfDoors) 
	{
		System.out.println("Please enter a door from 1-" + numOfDoors + " (i.e. \'1\')" );
		int userInput = keys.nextInt();
		keys.nextLine();
		while ((userInput > numOfDoors) || (userInput < 1)) {
			userInput = getUserDoor(numOfDoors);
		}
		return userInput;
	}
	
	/**
	* This method calculates an acceptable door to return to the user.
	* @param invalidDoor1 A door that the host cannot open
	* @param invalidDoor2 Another door that the host cannot open (may be the same as invalidDoor1)
	* @return The number of a door containing a goat. 
	**/
	public static int revealDoor(int invalidDoor1, int invalidDoor2, int numOfDoors) 
	{
		int validDoor = (int) ((Math.random() * numOfDoors) + 1.0); //making it as random
		// as possible
		while ((validDoor == invalidDoor1) || (validDoor == invalidDoor2))
		{
			validDoor = (int) ((Math.random() * numOfDoors) + 1.0);
			// making it random 
		}
		return validDoor;
		// I should never reach this line it is just to make the compiler feel better
		// return -1; I'm getting an error saying unreachable statement so I will assume
	}
	
	
	
}